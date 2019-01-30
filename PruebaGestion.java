package ProyectoBimestre;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public abstract class PruebaGestion extends GestionFacultad {

    public static final String RUTA = "C:\\Users\\luiyi\\Documents\\NetBeansProjects\\ProgramacionAlgoritmos\\Reporte.pdf";
    public static final String LOGO = "C:\\Users\\luiyi\\Documents\\NetBeansProjects\\ProgramacionAlgoritmos\\logo.png";

    public static void main(String[] args) throws IOException {

        //Declaracion de Variables
        String pedir, nombre = "", apellido = "", id = "", anio = "", numDes = "", opcion = "", tipo = "";

        try {
            File archivo = new File(RUTA);
            archivo.getParentFile().mkdir();

            PdfWriter writer = new PdfWriter(RUTA);
            PdfDocument pdf_fichero = new PdfDocument(writer);
            Document documento = new Document(pdf_fichero);
            //Crear fuente y titulo
            PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
            PdfFont f = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
            Text titulo = new Text("UNIVERSIDAD NACIONAL DE LOJA").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(20);
            Image imagen = new Image(ImageDataFactory.create(LOGO)).setHorizontalAlignment(HorizontalAlignment.CENTER);
            Paragraph p = new Paragraph().add(titulo);
            documento.add(p);
            documento.add(imagen);
            //Agregar tabla
            float[] anchoColumna = {2f, 2f, 2f, 2f, 2f, 2f};
            Table tabla = new Table(anchoColumna);
            Table tabla1 = new Table(anchoColumna);
            Table tabla2 = new Table(anchoColumna);

            Text titulo1 = new Text("TABLA EMPLEADOS").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(20);
            Paragraph p1 = new Paragraph().add(titulo1);

            tabla.setWidth(100);
            tabla.addCell("CEDULA");
            tabla.addCell("NOMBRE");
            tabla.addCell("APELLIDO");
            tabla.addCell("AÑO INCORPORACION");
            tabla.addCell("NUM DESPACHO");
            tabla.addCell("SALARIO");

            Text titulo2 = new Text("TABLA ESTUDIANTES").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(20);
            Paragraph p2 = new Paragraph().add(titulo2);

            tabla1.setWidth(100);
            tabla1.addCell("CEDULA");
            tabla1.addCell("NOMBRE");
            tabla1.addCell("APELLIDO");
            tabla1.addCell("CICLOS TOTALES");
            tabla1.addCell("CICLO EN CURSO");
            tabla1.addCell("SUELDO BECA");

            Text titulo3 = new Text("TABLA DOCENTES").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(20);
            Paragraph p3 = new Paragraph().add(titulo3);

            tabla2.setWidth(100);
            tabla2.addCell("CEDULA");
            tabla2.addCell("NOMBRE");
            tabla2.addCell("APELLIDO");
            tabla2.addCell("AREA");
            tabla2.addCell("TIPO TRABAJO");
            tabla2.addCell("SALARIO");

            Empleado emp = new Empleado() {
                @Override
                public void generaSueldo() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            Estudiante est = new Estudiante() {
                @Override
                public void generaSueldo() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            Profesor prf = new Profesor() {
                @Override
                public void generaSueldo() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            JOptionPane.showMessageDialog(null, "Bienvenido al programa");
            do {
                pedir = JOptionPane.showInputDialog(null, "Seleccione su Usuario\n1. Empleado\n2.Estudiante\n3.Profesor\n4.Mostrar Registros\n5.Salir");
                switch (Integer.parseInt(pedir)) {
                    case 1: {
                        documento.add(p1);
                        do {
                            opcion = JOptionPane.showInputDialog(null, "Empleado\n1. Registro Empleado\n2. Cambio Despacho\n3. Calculo Salario \n4. Guardar Registro\n5. Salir");
                            switch (Integer.parseInt(opcion)) {
                                case 1: {
                                    id = JOptionPane.showInputDialog(null, "Su Cédula: ");
                                    emp.setId(id);
                                    nombre = JOptionPane.showInputDialog(null, "Su Nombre: ");
                                    emp.setNombre(nombre);
                                    apellido = JOptionPane.showInputDialog(null, "Su Apellido: ");
                                    emp.setApellido(apellido);
                                    anio = JOptionPane.showInputDialog(null, "Año en el que empezó a laborar en la empresa: ");
                                    emp.setAnioincorporacion(Integer.parseInt(anio));
                                    numDes = JOptionPane.showInputDialog(null, "Ingrese el número de su cubículo: ");
                                    emp.setAnioincorporacion(Integer.parseInt(numDes));
                                    break;
                                }
                                case 2: {
                                    numDes = JOptionPane.showInputDialog(null, "Ingrese su nuevo número de Despacho:");
                                    emp.cambioDespacho(Integer.parseInt(numDes));
                                    JOptionPane.showMessageDialog(null, "Despacho cambiado con exito");
                                    break;
                                }
                                case 3: {
                                    JOptionPane.showMessageDialog(null, "Sueldo generado con éxito");
                                    emp.generaSueldo(Integer.parseInt(anio));
                                    break;
                                }
                                case 4: {
                                    JOptionPane.showMessageDialog(null, "Datos Almacenados con éxito");
                                    tabla.addCell(emp.getId());
                                    tabla.addCell(emp.getNombre());
                                    tabla.addCell(emp.getApellido());
                                    tabla.addCell(anio);
                                    tabla.addCell(numDes);
                                    tabla.addCell("" + emp.getSueldo());
                                    documento.add(tabla);
                                    break;
                                }
                            }
                        } while (Integer.parseInt(opcion) != 5);
                        break;
                    }
                    case 2: {
                        documento.add(p2);
                        do {
                            opcion = JOptionPane.showInputDialog(null, "Estudiante\n1. Registro Estudiante\n2. Matrícula nuevo ciclo\n3. Salario por Beca \n4. Guardar Registro\n5. Salir");
                            switch (Integer.parseInt(opcion)) {
                                case 1: {
                                    id = JOptionPane.showInputDialog(null, "Su Cédula: ");
                                    est.setId(id);
                                    nombre = JOptionPane.showInputDialog(null, "Su Nombre: ");
                                    est.setNombre(nombre);
                                    apellido = JOptionPane.showInputDialog(null, "Su Apellido: ");
                                    est.setApellido(apellido);
                                    anio = JOptionPane.showInputDialog(null, "Ciclo académico: ");
                                    est.setCiclo(Integer.parseInt(anio));
                                    break;
                                }
                                case 2: {
                                    numDes = JOptionPane.showInputDialog(null, "Ingrese el ciclo a matricularse:");
                                    est.matricular(Integer.parseInt(numDes));
                                    JOptionPane.showMessageDialog(null, "Matriculado con exito");
                                    break;
                                }
                                case 3: {
                                    numDes = JOptionPane.showInputDialog(null, "¿Usted posee Beca\n1. Si\n2. No?");
                                    if (Integer.parseInt(numDes) == 1) {
                                        est.generaSueldo(1);
                                        JOptionPane.showMessageDialog(null, "Proceso Generado con éxito");
                                    } else {
                                        est.generaSueldo(2);
                                        JOptionPane.showMessageDialog(null, "Proceso Generado con éxito");
                                    }
                                    break;
                                }
                                case 4: {
                                    JOptionPane.showMessageDialog(null, "Datos Almacenados con éxito");
                                    tabla1.addCell(est.getId());
                                    tabla1.addCell(est.getNombre());
                                    tabla1.addCell(est.getApellido());
                                    tabla1.addCell("10 Ciclos");
                                    tabla1.addCell("" + est.getCiclo());
                                    tabla1.addCell("" + est.getSueldo());
                                    documento.add(tabla1);
                                    break;
                                }
                            }
                        } while (Integer.parseInt(opcion) != 5);
                        break;
                    }
                    case 3: {
                        documento.add(p3);
                        do {
                            opcion = JOptionPane.showInputDialog(null, "Profesor\n1. Registro Profesor\n2. Registro Area Trabajo\n3. Cálculo Salario \n4. Guardar \n5. Salir");
                            switch (Integer.parseInt(opcion)) {
                                case 1: {
                                    id = JOptionPane.showInputDialog(null, "Su Cédula: ");
                                    prf.setId(id);
                                    nombre = JOptionPane.showInputDialog(null, "Su Nombre: ");
                                    prf.setNombre(nombre);
                                    apellido = JOptionPane.showInputDialog(null, "Su Apellido: ");
                                    prf.setApellido(apellido);
                                    break;
                                }
                                case 2: {
                                    numDes = JOptionPane.showInputDialog(null, "Seleccione Area\n1.Area Técnica\n2.Area SocioHumanística\n3. Area Biológica\n4. Area Idiomas");
                                    prf.asignArea(Integer.parseInt(numDes));
                                    opcion = JOptionPane.showInputDialog(null, "Seleccione Tipo Trabajador\n1.Tiempo Completo\n2.Tiempo Parcial");
                                    JOptionPane.showMessageDialog(null, "Registrado con exito");
                                    break;
                                }
                                case 3: {
                                    if (Integer.parseInt(opcion) == 1) {
                                        prf.generaSueldo(1);
                                        JOptionPane.showMessageDialog(null, "Salario Generado con éxito");
                                    } else {
                                        prf.generaSueldo(2);
                                        JOptionPane.showMessageDialog(null, "Salario Generado con éxito");
                                    }
                                    break;
                                }
                                case 4: {
                                    if (Integer.parseInt(opcion) == 1) {
                                        prf.generaSueldo(1);
                                        JOptionPane.showMessageDialog(null, "Datos Almacenados con éxito");
                                        tabla2.addCell(prf.getId());
                                        tabla2.addCell(prf.getNombre());
                                        tabla2.addCell(prf.getApellido());
                                        tabla2.addCell(prf.getDepartamento());
                                        tabla2.addCell(prf.getTipo());
                                        tabla2.addCell("" + prf.getSueldo());
                                        documento.add(tabla2);
                                    } else {
                                        prf.generaSueldo(2);
                                        JOptionPane.showMessageDialog(null, "Datos Almacenados con éxito");
                                        tabla2.addCell(prf.getId());
                                        tabla2.addCell(prf.getNombre());
                                        tabla2.addCell(prf.getApellido());
                                        tabla2.addCell(prf.getDepartamento());
                                        tabla2.addCell(prf.getTipo());
                                        tabla2.addCell("" + prf.getSueldo());
                                        documento.add(tabla2);
                                    }
                                }
                            } 
                        } while (Integer.parseInt(opcion) != 5);
                    }
                    case 4: {
                        documento.close();
                        Desktop.getDesktop().open(archivo);
                    }
                    case 5: {
                        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema...");
                        System.exit(0);
                    }
                }
            } while (Integer.parseInt(pedir) != 5);
        } catch (Exception e) {
        }
    }

}
