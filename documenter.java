import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class documenter extends CSharpParserBaseListener {
    public String file = "";
    public int enterCompilation = 0;
    public int enterClass = 0;
    public int enterLib = 0;
    public int enterMeth = 0;
    public int enterVar = 0;
    public int enterNam = 0;


    @Override public void enterCompilation_unit(CSharpParser.Compilation_unitContext ctx) {
       // System.out.printf("El codigo fuente posee las siguientes caracteristicas:\n");
        enterCompilation++;
        file ="<center><table width=\"640\" cellspacing=\"1\" cellpadding=\"3\" border=\"0\" " +
                "bgcolor=\"#A9A9F5\"> <tr><td><hr>\n" +
                "<div class=\"Documenter\">\n" +
                "<h2><center>DOCUMENTADOR</center></h2><h3><center>Abstracci&oacuten visual del c&oacutedigo fuente</center></h3></td></tr>";
             //System.out.printf(file);
    }

    @Override public void exitCompilation_unit(CSharpParser.Compilation_unitContext ctx) {
        file = file + "</table></center>";
    }

    @Override public void enterClass_definition(CSharpParser.Class_definitionContext ctx) {
        enterClass++;
       // System.out.printf("Clase ");
        //System.out.printf(ctx.identifier().getText());
        //System.out.print("\n");
        file = file + "<tr><td bgcolor=\"#E6E6E6\"> Clase " + ctx.identifier().getText() + "";
        //System.out.print("\n");
        //System.out.printf(file);
    }
    @Override public void exitClass_definition(CSharpParser.Class_definitionContext ctx) {
        file = file +"</tr></td>";
    }

    @Override public void enterUsingNamespaceDirective(CSharpParser.UsingNamespaceDirectiveContext ctx){
        enterLib++;

        //System.out.printf("Librer&iacutea ");
        //System.out.printf(ctx.namespace_or_type_name().getText());
       // System.out.print("\n");
        //file = file + " libreria " + ctx.namespace_or_type_name().getText() + " ";
        file = file + "<tr><td bgcolor=\"#A9F5D0\"> Librer&iacutea " + ctx.namespace_or_type_name().getText() ;
        //System.out.print("\n");
        //System.out.printf(file);
        //System.out.printf("cantidad de librer&iacuteas " + enterLib);
    }
    @Override public void exitUsingNamespaceDirective(CSharpParser.UsingNamespaceDirectiveContext ctx) {
        file = file + "</tr></td>";
    }
    @Override public void enterLocal_variable_declarator(CSharpParser.Local_variable_declaratorContext ctx){
        enterVar++;
        //System.out.printf("Variable ");
        //System.out.printf(ctx.identifier().getText());
        //System.out.print("\n");
         //file = file + " variable " + ctx.identifier().getText() + " ";
        file = file + "<tr><td bgcolor=\"#F5DA81\">Variable " + ctx.identifier().getText() + "</p>";
        // System.out.print("\n");
         //System.out.printf(file);
        FileWriter flwriter = null;
        try {
            //crea el flujo para escribir en el archivo
            flwriter = new FileWriter("C:\\Users\\jygut\\Desktop\\test.html");
            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(file);
            //cierra el buffer intermedio
            bfwriter.close();
            System.out.println("Archivo creado satisfactoriamente..");

        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.printf("cantidad de variables " + enterVar);
    }
    @Override public void exitLocal_variable_declarator(CSharpParser.Local_variable_declaratorContext ctx) {
        file = file + "</tr></td>";
    }
    @Override public void enterNamespace_declaration(CSharpParser.Namespace_declarationContext ctx) {
        enterNam++;
        //System.out.printf("Namespace ");
        //System.out.printf(ctx.qualified_identifier().getText());
        //System.out.print("\n");
      //  file = file + " namespace " + ctx.qualified_identifier().getText() + " ";
        file = file + "<tr><td bgcolor=\"#F5A9A9\">Namespace " + ctx.qualified_identifier().getText();
        //System.out.print("\n");
        //System.out.printf(file);
    }
    @Override public void exitNamespace_declaration(CSharpParser.Namespace_declarationContext ctx) {
        file = file + "</tr></td>";
    }

    @Override public void enterMethod_declaration(CSharpParser.Method_declarationContext ctx) {
        enterMeth++;
        //System.out.printf("m&eacutetodo ");
        //System.out.printf(ctx.method_member_name().getText());
        //System.out.print("\n");
        //file = file + " metodo " + ctx.method_member_name().getText() + " ";
        file = file + "<tr><td bgcolor=\"##F5A9F2\">M&eacutetodo " + ctx.method_member_name().getText();
        //System.out.print("\n");
        //System.out.printf(file);
        //System.out.printf("cantidad de m&eacutetodos " + enterMeth);
    }
    @Override public void exitMethod_declaration(CSharpParser.Method_declarationContext ctx) {
        file = file + "</tr></td>";
    }
    @Override public void enterArg_declaration(CSharpParser.Arg_declarationContext ctx) {
        //System.out.printf("Argumentos del m&eacutetodo de tipo ");
        //System.out.printf(ctx.type_().getText());
        //System.out.printf(" con nombre ");
        //System.out.printf(ctx.identifier().getText());
        //System.out.print("\n");
        //file = file + " argumentos del metodo de tipo " + ctx.type_().getText() + " con nombre " + ctx.identifier().getText() + " ";
        file = file + " <p> Argumentos del m&eacutetodo de tipo <b>" + ctx.type_().getText() + "</b> con nombre <b>" + ctx.identifier().getText() + "</b>";
        //System.out.print("\n");
        //System.out.printf(file);

        FileWriter flwriter = null;
        try {
            //crea el flujo para escribir en el archivo
            flwriter = new FileWriter("C:\\Users\\jygut\\Desktop\\test.html");
            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(file);
            //cierra el buffer intermedio
            bfwriter.close();
            //System.out.println("Archivo creado satisfactoriamente..");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}