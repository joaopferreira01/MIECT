import vtk
import os


def main():
    # Leitor para carregar a imagem JPEG
    jpgReader = vtk.vtkJPEGReader()
    current_dir = os.path.dirname(os.path.abspath(__file__))
    image_path = os.path.join(current_dir, "images/lena.jpg")
    jpgReader.SetFileName(image_path)

    # Criar a textura a partir da imagem carregada
    texture = vtk.vtkTexture()
    texture.SetInputConnection(jpgReader.GetOutputPort())

    # Criar o plano e definir seu tamanho usando SetOrigin, SetPoint1 e SetPoint2
    planeSource = vtk.vtkPlaneSource()
    planeSource.SetOrigin(0, 0, 0)       # Ponto inicial (origem)
    planeSource.SetPoint1(3, 0, 0)       # Define a extensão ao longo do eixo X
    planeSource.SetPoint2(0, 3, 0)       # Define a extensão ao longo do eixo Y
    planeSource.SetXResolution(10)
    planeSource.SetYResolution(10)

    # Mapper para o plano
    planeMapper = vtk.vtkPolyDataMapper()
    planeMapper.SetInputConnection(planeSource.GetOutputPort())

    # Ator para o plano com a textura aplicada
    planeActor = vtk.vtkActor()
    planeActor.SetMapper(planeMapper)
    planeActor.SetTexture(texture)

    # Criar o renderizador e adicionar o ator do plano
    renderer = vtk.vtkRenderer()
    renderer.AddActor(planeActor)
    renderer.SetBackground(0.1, 0.2, 0.4)  # Cor de fundo

    # Criar a janela de renderização
    renderWindow = vtk.vtkRenderWindow()
    renderWindow.AddRenderer(renderer)
    renderWindow.SetSize(800, 600)
    renderWindow.SetWindowName("Textured Plane with Modified Size")

    # Interator para interação com a janela
    renderWindowInteractor = vtk.vtkRenderWindowInteractor()
    renderWindowInteractor.SetRenderWindow(renderWindow)

    # Iniciar o loop de renderização
    renderWindow.Render()
    renderWindowInteractor.Start()

if __name__ == "__main__":
    main()