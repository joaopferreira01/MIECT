import java.io.File;
import org.stringtemplate.v4.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;

@SuppressWarnings("CheckReturnValue")
public class Execute extends csvBaseVisitor<ST> {
   private final STGroup htmlGroup;

   public Execute() {
      htmlGroup = new STGroupFile("htmlTemplate.stg");
   }

   @Override
   public ST visitFile(csvParser.FileContext ctx) {
      ST html = htmlGroup.getInstanceOf("html");

      // Adicionar cabeçalho da tabela HTML
      ST header = htmlGroup.getInstanceOf("header");
      for (csvParser.FieldContext fieldCtx : ctx.header().row().field()) {
         ST cell = htmlGroup.getInstanceOf("cell");
         cell.add("data", visit(fieldCtx).render());
         header.add("cell", cell.render());
      }
      html.add("header", header.render());

      // Adicionar linhas da tabela HTML
      ST rows = htmlGroup.getInstanceOf("rows");
      for (csvParser.RowContext rowCtx : ctx.row()) {
         ST row = htmlGroup.getInstanceOf("row");
         for (csvParser.FieldContext fieldCtx : rowCtx.field()) {
            ST cell = htmlGroup.getInstanceOf("cell");
            cell.add("data", visit(fieldCtx).render());
            row.add("cell", cell.render());
         }
         rows.add("row", row.render());
      }
      html.add("rows", rows.render());

      // Adicionar rodapé da tabela HTML
      ST footer = htmlGroup.getInstanceOf("footer");
      html.add("footer", footer.render());

      return html;
   }

   @Override
   public ST visitField(csvParser.FieldContext ctx) {
      // Verificar se o contexto é nulo
      if (ctx == null) {
         throw new IllegalArgumentException("FieldContext is null");
      }

      // Verificar se o grupo StringTemplate é nulo
      if (htmlGroup == null) {
         throw new IllegalStateException("STGroup is null");
      }

      // Renderizar o conteúdo do campo
      ST cell = htmlGroup.getInstanceOf("cell");
      String text = ctx.getText();
      if (text != null) {
         cell.add("data", text);
      } else {
         throw new IllegalArgumentException("FieldContext text is null");
      }
      return cell;
   }

}
