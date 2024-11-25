let countryNames = []; // Armazena os nomes dos países

var width = window.innerWidth / 2, height = window.innerHeight * 0.85;
var projection = d3.geoMercator()
  .scale(window.innerWidth / 13)
  .translate([width / 2, height / 1.7]);

var path = d3.geoPath().projection(projection);
var sportColorScale = d3.scaleQuantize().domain([0, 50]).range(d3.schemeBlues[9]);
var obesityColorScale = d3.scaleQuantize().domain([0, 50]).range(d3.schemeYlOrBr[9]);

var selectedFilters = { ageGroup: "children", gender: "male" };
var selectedCountryCodes = new Set(); // Armazena os códigos dos países selecionados

let dataByCountry = {}; // Coloca o dataByCountry em um escopo acessível

function renderBarChart(data, containerId, yLabel) {
  // Remover qualquer gráfico existente
  d3.select(containerId).selectAll("*").remove();

  const margin = { top: 20, right: 30, bottom: 40, left: 90 };
  const width = 500 - margin.left - margin.right;
  const height = 300 - margin.top - margin.bottom;

  // Criar SVG
  const svg = d3.select(containerId)
    .append("svg")
    .attr("width", width + margin.left + margin.right)
    .attr("height", height + margin.top + margin.bottom)
    .append("g")
    .attr("transform", `translate(${margin.left},${margin.top})`);

  // Escalas
  const x = d3.scaleLinear()
    .domain([0, 50])
    .range([0, width]);

  const y = d3.scaleBand()
    .domain(data.map(d => d.country))
    .range([0, height])
    .padding(0.1);

  // Criar tooltip
  const tooltip = d3.select("body")
    .append("div")
    .attr("class", "tooltip")
    .style("position", "absolute")
    .style("visibility", "hidden")
    .style("background-color", "rgba(0, 0, 0, 0.7)")
    .style("color", "white")
    .style("padding", "5px")
    .style("border-radius", "5px")
    .style("font-size", "12px")
    .style("pointer-events", "none")
    .style("z-index", "9999"); // Adicionado para ficar acima do modal

  // Criar barras
  svg.selectAll("rect")
    .data(data)
    .enter()
    .append("rect")
    .attr("x", x(0))
    .attr("y", d => y(d.country))
    .attr("width", d => x(d.value))
    .attr("height", y.bandwidth())
    .attr("fill", "#69b3a2")
    .on("mouseover", function (event, d) {
      tooltip.style("visibility", "visible")
        .text(`${d.country}: ${d.value.toFixed(2)}%`);
    })
    .on("mousemove", function (event) {
      tooltip.style("top", (event.pageY - 40) + "px")
        .style("left", (event.pageX + 10) + "px");
    })
    .on("mouseout", function () {
      tooltip.style("visibility", "hidden");
    });

  // Adicionar eixos
  svg.append("g").call(d3.axisLeft(y));
  svg.append("g").attr("transform", `translate(0,${height})`).call(d3.axisBottom(x));

  // Adicionar título ao eixo X
  svg.append("text")
    .attr("x", width / 2)
    .attr("y", height + margin.bottom - 5)
    .attr("text-anchor", "middle")
    .attr("font-size", "12px")
    .text(yLabel);
}


function updateTop10Lists(dataByCountry) {
  const ageGroup = selectedFilters.ageGroup;
  const gender = selectedFilters.gender;

  const sportsTop10 = Object.values(dataByCountry)
    .map(countryData => {
      const data = countryData[ageGroup][gender];
      return {
        country: data.Country,
        value: parseFloat(data['Sports Participation (%)'] || 0)
      };
    })
    .sort((a, b) => b.value - a.value)
    .slice(0, 10);

  const obesityTop10 = Object.values(dataByCountry)
    .map(countryData => {
      const data = countryData[ageGroup][gender];
      return {
        country: data.Country,
        value: parseFloat(data['Obesity Rate (%)'] || 0)
      };
    })
    .sort((a, b) => b.value - a.value)
    .slice(0, 10);

  renderBarChart(sportsTop10, "#sportsChart", "Sports Participation (%)");
  renderBarChart(obesityTop10, "#obesityChart", "Obesity Rate (%)");
}

Promise.all([
  d3.json("https://d3js.org/world-110m.v1.json"),
  d3.csv("dataset/dataset.csv")
]).then(function ([worldData, csvData]) {
  var countries = topojson.feature(worldData, worldData.objects.countries).features;

  csvData.forEach(function (d) {
    if (d['ISO Code']) {
      if (!dataByCountry[d['ISO Code']]) {
        dataByCountry[d['ISO Code']] = { children: {}, adult: {} };
      }

      const football = parseFloat(d['Football (%)']) || 0;
      const basketball = parseFloat(d['Basketball (%)']) || 0;
      const running = parseFloat(d['Running (%)']) || 0;
      const averageSportsParticipation = ((football + basketball + running) / 3).toFixed(2);

      dataByCountry[d['ISO Code']][d.Group.toLowerCase()][d.Gender.toLowerCase()] = {
        ...d,
        "Sports Participation (%)": averageSportsParticipation
      };
    }
  });

  function addColorLegend(svg, colorScale, title, x, y) {
    const legend = svg.append("g")
      .attr("class", "color-legend")
      .attr("transform", `translate(${x}, ${y})`);

    const legendData = colorScale.range().map(color => {
      const d = colorScale.invertExtent(color);
      return { color, value: d[0] };
    });

    // Formata os números (arredonda para 1 casa decimal)
    const formatNumber = d3.format(".0f");

    // Adiciona os retângulos coloridos da legenda
    legend.selectAll("rect")
      .data(legendData)
      .enter()
      .append("rect")
      .attr("x", (d, i) => i * 30) // Ajuste horizontal para escala
      .attr("y", 0)
      .attr("width", 30)
      .attr("height", 20)
      .attr("fill", d => d.color);

    // Adiciona os valores formatados
    legend.selectAll("text")
      .data(legendData)
      .enter()
      .append("text")
      .attr("x", (d, i) => i * 30 + 15) // Ajuste horizontal para texto
      .attr("y", 40)
      .text(d => formatNumber(d.value)) // Aplica o formato
      .style("font-size", "12px")
      .style("text-anchor", "middle")
      .style("font-weight", "bold"); // Torna os números em negrito

    // Adiciona o título da legenda
    legend.append("text")
      .attr("x", 0)
      .attr("y", -10)
      .text(title)
      .style("font-size", "14px")
      .style("font-weight", "bold");
  }


  function drawMap(containerId, dataType, title, colorScale) {
    // Remove o SVG existente no contêiner
    d3.select(containerId).selectAll("svg").remove();

    // Cria o SVG e os grupos para o mapa e a legenda
    var svg = d3.select(containerId).append("svg").attr("width", width).attr("height", height);
    var mapGroup = svg.append("g").attr("class", "map-group"); // Grupo para o mapa
    var legendGroup = svg.append("g").attr("class", "legend-group"); // Grupo para a legenda

    // Adiciona a legenda no grupo correspondente
    if (dataType == "sports") {
        addColorLegend(legendGroup, sportColorScale, "Sports Participation (%)", width - 350, 20);
    } else {
        addColorLegend(legendGroup, obesityColorScale, "Obesity Rate (%)", width - 300, 20);
    }

    // Desenha os países no grupo do mapa
    mapGroup.selectAll("path")
        .data(countries.filter(d => d.id !== "010")) // Exclui a Antártida
        .join("path")
        .attr("class", "country")
        .attr("d", path)
        .attr("fill", function (d) {
            var countryCode = d.id;
            var countryData = dataByCountry[countryCode];

            if (selectedCountryCodes.has(countryCode)) {
                return "#FF0000";
            }

            if (countryData) {
                var selectedData = countryData[selectedFilters.ageGroup][selectedFilters.gender];
                if (selectedData) {
                    var value = dataType === "sports"
                        ? parseFloat(selectedData['Sports Participation (%)'])
                        : parseFloat(selectedData['Obesity Rate (%)']);
                    return colorScale(value);
                }
            }
            return "#ccc";
        })
        .on("mouseover", function (event, d) {
            var countryCode = d.id;
            var countryData = dataByCountry[countryCode];

            if (countryData) {
                var selectedData = countryData[selectedFilters.ageGroup][selectedFilters.gender];
                if (selectedData) {
                    var popup = d3.select("#popup");
                    var content = `<h3>${selectedData.Country}</h3>`;

                    if (dataType === "sports") {
                        var sportsParticipation = selectedData['Sports Participation (%)'] || 'N/A';
                        content += `<p>Sports Participation: ${sportsParticipation}%</p>`;
                    } else {
                        var obesityRate = selectedData['Obesity Rate (%)'] || 'N/A';
                        content += `<p>Obesity Rate: ${obesityRate}%</p>`;
                    }

                    popup.style("left", (event.pageX + 10) + "px")
                        .style("top", (event.pageY - 50) + "px")
                        .style("display", "block")
                        .html(content);
                }
            }
        })
        .on("mouseleave", function () {
            d3.select("#popup").style("display", "none");
        })
        .on("click", function (event, d) {
            var countryCode = d.id;
            if (selectedCountryCodes.has(countryCode)) {
                selectedCountryCodes.delete(countryCode);
                selectCountry(dataByCountry[countryCode]);
            } else {
                selectedCountryCodes.add(countryCode);
                selectCountry(dataByCountry[countryCode]);
            }
            drawMaps();
        });

    // Configura o zoom no grupo do mapa
    var zoom = d3.zoom()
        .scaleExtent([1, 8]) // Define os limites de zoom
        .translateExtent([[0, 0], [width - 350, height]]) // Define os limites para translação
        .on("zoom", function (event) {
            mapGroup.attr("transform", event.transform); // Aplica o zoom apenas ao mapa
        });

    svg.call(zoom);
}


  function drawMaps() {
    drawMap("#map1", "sports", "Global Sports Participation Rate", sportColorScale);
    drawMap("#map2", "obesity", "Global Obesity Rate", obesityColorScale);
    updateTop10Lists(dataByCountry);
  }

  drawMaps();

  function updateFilters() {
    selectedFilters.ageGroup = document.querySelector("input[name='ageGroup']:checked").value;
    selectedFilters.gender = document.querySelector("input[name='gender']:checked").value;
    drawMaps();
  }

  document.getElementById("generateBtn").addEventListener("click", () => {
    updateTop10Lists(dataByCountry);
    updateFilters();
  });


}).catch(function (error) {
  console.error("Error loading data: ", error);
});

function selectCountry(countryObj) {
  let country_value = null;
  for (const ageGroup in countryObj) {
    const genderData = countryObj[ageGroup];
    for (const gender in genderData) {
      const countryData = genderData[gender];
      if (!countryNames.includes(countryData.Country)) {
        countryNames.push(countryData.Country);
        country_value = countryData.Country;
      } else {
        country_value = countryData.Country;
      }
    }
  }
  let selectedCountries = JSON.parse(localStorage.getItem("selectedCountries")) || [];
  if (country_value !== null) {
    if (selectedCountries.includes(country_value)) {
      selectedCountries = selectedCountries.filter(c => c !== country_value);
    } else {
      selectedCountries.push(country_value);
    }
  }
  localStorage.setItem("selectedCountries", JSON.stringify(selectedCountries));
}

window.onload = function () {
  localStorage.removeItem("selectedCountries");
};


document.addEventListener("DOMContentLoaded", function () {

  document.getElementById("viewTop10Btn").addEventListener("click", showTop10Modal);

  // Adiciona o evento para fechar o modal quando clicar em "Close"
  document.getElementById("closeModalBtn").addEventListener("click", closeModal);


  // Seleciona o contêiner dos mapas
  const mapContainer = document.querySelector(".maps-container");

  function showTop10Modal() {
    // Exibe o modal
    document.getElementById("top10Modal").style.display = "block";

    // Torna os mapas opacos
    mapContainer.style.opacity = "0.3";
  }

  function closeModal() {
    // Esconde o modal
    document.getElementById("top10Modal").style.display = "none";

    // Restaura a opacidade dos mapas
    mapContainer.style.opacity = "1";
  }




});