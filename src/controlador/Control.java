package controlador;

import java.awt.event.*;
import vista.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.*;

public class Control implements ActionListener{
    MenuPrincipal FrmMprincipal;
    MenuLocales FrmMenuLocales;
    MenuEmpleados FrmMenuEmpleados;
    AgregarLocal FrmAgregarLocal;
    EliminarLocal FrmEliminarLocal;
    AgregarEmpleado FrmAgregarEmpleado;
    CasoVendedor FrmCasoVendedor;
    CasoSeguridad FrmCasoSeguridad;
    CasoAdministrador FrmCasoAdministrador;
    EliminarEmpleado FrmEliminarEmpleado;
    RegistroEntraSale FrmEntraSale;
    CalcularSalario FrmCalcular;
    VistaLocal FrmListaLocales;
    VistaEmpleado FrmListaEmpleados;
    ArrayList<Empleado> empleados = new ArrayList<>();
    ArrayList<Local> locales = new ArrayList<>();
    Scanner lecture = new Scanner (System.in);
    Empleado objEmpleado;
    Local objLocal;
    

    public Control() {
        FrmMprincipal = new MenuPrincipal();
        FrmMenuLocales = new MenuLocales();
        FrmMenuEmpleados = new MenuEmpleados();
        FrmAgregarLocal = new AgregarLocal();
        FrmEliminarLocal = new EliminarLocal();
        FrmAgregarEmpleado = new AgregarEmpleado();
        FrmCasoVendedor = new CasoVendedor();
        FrmCasoSeguridad = new CasoSeguridad();
        FrmCasoAdministrador = new CasoAdministrador();
        FrmEliminarEmpleado = new EliminarEmpleado();
        FrmEntraSale = new RegistroEntraSale();
        FrmCalcular = new CalcularSalario();
        FrmListaLocales = new VistaLocal();
        FrmListaEmpleados = new VistaEmpleado();
        
        //frame principal
        FrmMprincipal.getBtnLocales().addActionListener(this);
        FrmMprincipal.getBtnEmpleados().addActionListener(this);
        //frame locales
        FrmMenuLocales.getBtnAddLocal().addActionListener(this);
        FrmMenuLocales.getBtnEliminarLocal().addActionListener(this);
        FrmMenuLocales.getBtnListaLocales().addActionListener(this);
        FrmMenuLocales.getBtnVolver().addActionListener(this);
        // Agregar Local
        FrmAgregarLocal.getBtnVolver().addActionListener(this);
        FrmAgregarLocal.getBtnAgregar().addActionListener(this);
        FrmAgregarLocal.getBtnCancelar().addActionListener(this);
        // Eliminar Local
        FrmEliminarLocal.getBtnVolver().addActionListener(this);
        FrmEliminarLocal.getBtnCancelar().addActionListener(this);
        FrmEliminarLocal.getBtnEliminar().addActionListener(this);
        //frame empleados
        FrmMenuEmpleados.getBtnAddEmpleado().addActionListener(this);
        FrmMenuEmpleados.getBtnEliminarEmpleado().addActionListener(this);
        FrmMenuEmpleados.getBtnListaEmpleados().addActionListener(this);
        FrmMenuEmpleados.getBtnVolver().addActionListener(this);
        FrmMenuEmpleados.getBtnCalcular().addActionListener(this);
        FrmMenuEmpleados.getBtnRegistro().addActionListener(this);
        //Agregar empleados
        FrmAgregarEmpleado.getBtnAgregar().addActionListener(this);
        FrmAgregarEmpleado.getBtnCancelar().addActionListener(this);
        FrmAgregarEmpleado.getBtnVolver().addActionListener(this);
        FrmCasoVendedor.getBtnAgregarVendedor().addActionListener(this);
        FrmCasoVendedor.getBtnCancelarVe().addActionListener(this);
        FrmCasoSeguridad.getBtnAgregarSeguridad().addActionListener(this);
        FrmCasoSeguridad.getBtnCancelarSeguridad().addActionListener(this);
        FrmCasoAdministrador.getBtnAgregarAdministrador().addActionListener(this);
        FrmCasoAdministrador.getBtnCancelarAdministrador().addActionListener(this);
        //Eliminar empleados
        FrmEliminarEmpleado.getBtnCancelar().addActionListener(this);
        FrmEliminarEmpleado.getBtnEliminar().addActionListener(this);
        FrmEliminarEmpleado.getBtnVolver().addActionListener(this);
        //Registrar
        FrmEntraSale.getBtnVolver().addActionListener(this);
        FrmEntraSale.getBtnCancelar().addActionListener(this);
        FrmEntraSale.getBtnRegistrar().addActionListener(this);
        //Calcular
        FrmCalcular.getBtnVolver().addActionListener(this);
        FrmCalcular.getBtnCancelar().addActionListener(this);
        FrmCalcular.getBtnCalcular().addActionListener(this);
        //Lista Locales
        FrmListaLocales.getBtnVolver().addActionListener(this);
        //Lista Empleados
        FrmListaEmpleados.getBtnVolver().addActionListener(this);
    }
    public void iniciar (){
        FrmMprincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Menu principal
        if (e.getSource()==FrmMprincipal.getBtnLocales()) {
            FrmMenuLocales.setVisible(true);
            FrmMprincipal.setVisible(false);
        }
        if (e.getSource()==FrmMprincipal.getBtnEmpleados()) {
            FrmMenuEmpleados.setVisible(true);
            FrmMprincipal.setVisible(false);
        }
        //Local
        if (e.getSource()==FrmMenuLocales.getBtnVolver()) {
            FrmMprincipal.setVisible(true);
            FrmMenuLocales.setVisible(false);
        }
        if (e.getSource()==FrmMenuLocales.getBtnAddLocal()) {
            FrmAgregarLocal.setVisible(true);    
        }
        //AgregarLocal
        if (e.getSource()==FrmAgregarLocal.getBtnAgregar()) {
            if (!FrmAgregarLocal.getTxtNombreEmp().getText().equals("")&&!FrmAgregarLocal.getTxtTipoProducto().getText().equals("")) {
                if (locales.size()==7) {
                    FrmAgregarLocal.getLblNoAsignado().setText("<html> Cantidad maxima <p> de locales alcanzado <html>");
                }
                else{
                    objLocal = new Local((locales.size()+1),FrmAgregarLocal.getTxtNombreEmp().getText(),FrmAgregarLocal.getTxtTipoProducto().getText());
                    locales.add(objLocal);
                    FrmCasoVendedor.getCboLocal().addItem(objLocal.getNombre());
                    FrmAgregarLocal.getLblNoAsignado().setText("" + objLocal.getId());
                }
            }else{
                FrmAgregarLocal.getLblNoAsignado().setText("<html>No se ha podido<p>registrar<html>");
            }
        }
        if (e.getSource()==FrmAgregarLocal.getBtnVolver() ) {
            FrmAgregarLocal.setVisible(false);
            FrmMprincipal.setVisible(true);   
            FrmAgregarLocal.getLblNoAsignado().setText("");
            FrmAgregarLocal.getTxtNombreEmp().setText("");
            FrmAgregarLocal.getTxtTipoProducto().setText("");
        }  
        if (e.getSource()==FrmAgregarLocal.getBtnCancelar()) {
            FrmAgregarLocal.setVisible(false);
            FrmAgregarLocal.getLblNoAsignado().setText("");
            FrmAgregarLocal.getTxtNombreEmp().setText("");
            FrmAgregarLocal.getTxtTipoProducto().setText("");
        }
        //Eliminar Local
        if (e.getSource()==FrmMenuLocales.getBtnEliminarLocal()) {
            FrmEliminarLocal.setVisible(true);
        }
        if (e.getSource()==FrmEliminarLocal.getBtnVolver()) {
            FrmEliminarLocal.setVisible(false);
            FrmMprincipal.setVisible(true);
            FrmEliminarLocal.getLblVerify().setText("");
            FrmEliminarLocal.getTxtNombre().setText("");
            FrmEliminarLocal.getTxtNoLocal().setText("");
        }
        if (e.getSource()==FrmEliminarLocal.getBtnCancelar()) {
            FrmEliminarLocal.setVisible(false);
            FrmEliminarLocal.getLblVerify().setText("");
            FrmEliminarLocal.getTxtNombre().setText("");
            FrmEliminarLocal.getTxtNoLocal().setText("");
        }
        if (e.getSource()==FrmEliminarLocal.getBtnEliminar()) {
            if (!FrmEliminarLocal.getTxtNombre().getText().equals("")) {
                String nombre = FrmEliminarLocal.getTxtNombre().getText();
                for (int i = 0; i < locales.size(); i++) {
                    if (nombre.equalsIgnoreCase(locales.get(i).getNombre())) {
                        FrmCasoVendedor.getCboLocal().removeItem(nombre);                    
                        locales.remove(i);
                        FrmEliminarLocal.getLblVerify().setText("Local eliminado");
                        break;
                    }    
                }
                
            }else if(!FrmEliminarLocal.getTxtNoLocal().getText().equals("")){
                try{
                   int num = Integer.parseInt(FrmEliminarLocal.getTxtNoLocal().getText());
                   if (num<locales.size()) {
                       FrmCasoVendedor.getCboLocal().removeItem(locales.get(num-1).getNombre());
                       locales.remove(num-1);
                       FrmEliminarLocal.getLblVerify().setText("Local eliminado");
                   }
                   else{
                      FrmEliminarLocal.getLblVerify().setText("Este local no existe");
                  } 
                }
                catch(NumberFormatException f){
                    FrmEliminarLocal.getLblVerify().setText("Ha introducido incorrectamente la id del local");
                }
                
            }else{
                FrmEliminarLocal.getLblVerify().setText("Por favor digite la información indicada");
            }
        }
        //Empleado
        if (e.getSource()==FrmMenuEmpleados.getBtnAddEmpleado()) {
            FrmAgregarEmpleado.setVisible(true);
        }
        if (e.getSource()==FrmMenuEmpleados.getBtnVolver()) {
            FrmMprincipal.setVisible(true);
            FrmMenuEmpleados.setVisible(false);
        }
        //AgregarEmpleado
        if (e.getSource()==FrmAgregarEmpleado.getBtnCancelar()) {
            FrmAgregarEmpleado.setVisible(false);    
            FrmAgregarEmpleado.getLblVerify().setText("");
            FrmAgregarEmpleado.getTxtNombre().setText("");
            FrmAgregarEmpleado.getTxtEdad().setText("");
            FrmAgregarEmpleado.getTxtCedula().setText("");
            FrmAgregarEmpleado.getTxtEPS().setText("");
            FrmAgregarEmpleado.getLblVerify().setText("");
        }
        if (e.getSource()==FrmAgregarEmpleado.getBtnVolver()) {
            FrmMprincipal.setVisible(true);
            FrmAgregarEmpleado.setVisible(false);
            FrmAgregarEmpleado.getLblVerify().setText("");
            FrmAgregarEmpleado.getTxtNombre().setText("");
            FrmAgregarEmpleado.getTxtEdad().setText("");
            FrmAgregarEmpleado.getTxtCedula().setText("");
            FrmAgregarEmpleado.getTxtEPS().setText("");
        }
        if (e.getSource()==FrmAgregarEmpleado.getBtnAgregar()||e.getSource()==FrmCasoSeguridad.getBtnAgregarSeguridad()||e.getSource()==FrmCasoAdministrador.getBtnAgregarAdministrador()||e.getSource()==FrmCasoVendedor.getBtnAgregarVendedor()) {
            if (!FrmAgregarEmpleado.getTxtNombre().getText().equals("")&&!FrmAgregarEmpleado.getTxtCedula().getText().equals("")&&!FrmAgregarEmpleado.getTxtEPS().getText().equals("")&&!FrmAgregarEmpleado.getTxtEdad().getText().equals("")) {
                try{
                    String opcion = FrmAgregarEmpleado.getCboRol().getSelectedItem().toString();
                    String nombre = FrmAgregarEmpleado.getTxtNombre().getText();
                    int edad = Integer.parseInt(FrmAgregarEmpleado.getTxtEdad().getText());
                    long cedula = Long.parseLong(FrmAgregarEmpleado.getTxtCedula().getText());
                    String EPS = FrmAgregarEmpleado.getTxtEPS().getText();
                    switch (opcion){
                        case "Aseo":
                            objEmpleado = new Aseo(nombre, edad, cedula, EPS, false, "Aseo");
                            empleados.add(objEmpleado);
                            FrmAgregarEmpleado.getLblVerify().setText("Se ha agregado con exito al empleado");
                            break;
                        case "Seguridad":
                            FrmCasoSeguridad.setVisible(true);
                            if (e.getSource()==FrmCasoSeguridad.getBtnAgregarSeguridad()) {
                                String horario = FrmCasoSeguridad.getCboHorario().getSelectedItem().toString();
                                objEmpleado = new Seguridad(horario , nombre, edad, cedula, EPS, false, "Seguridad");
                                empleados.add(objEmpleado);
                                FrmCasoSeguridad.setVisible(false);
                                FrmAgregarEmpleado.getLblVerify().setText("Se ha agregado con exito al empleado");
                            }
                            
                            break;
                        case "Administrador":
                            FrmCasoAdministrador.setVisible(true);
                            if (!FrmCasoAdministrador.getTxtArea().getText().equals("")&& e.getSource()==FrmCasoAdministrador.getBtnAgregarAdministrador()) {
                                String area = FrmCasoAdministrador.getTxtArea().getText();
                                objEmpleado = new Administracion(area, nombre, edad, cedula, EPS, false, "Administrador");
                                empleados.add(objEmpleado);
                                FrmCasoAdministrador.setVisible(false);
                                FrmAgregarEmpleado.getLblVerify().setText("Se ha agregado con exito al empleado");
                            }                        
                            break;
                        case "Vendedor": 
                            if (locales.isEmpty()) {
                                FrmAgregarEmpleado.getLblVerify().setText("No se han registrado locales aún");
                            }
                            else{
                                FrmCasoVendedor.setVisible(true);
                                if (e.getSource()==FrmCasoVendedor.getBtnAgregarVendedor()) {
                                    String local = FrmCasoVendedor.getCboLocal().getSelectedItem().toString();
                                    objEmpleado = new Vendedor(local, nombre, edad, cedula, EPS, false, "Vendedor");
                                    empleados.add(objEmpleado);
                                    FrmCasoVendedor.setVisible(false);
                                    FrmAgregarEmpleado.getLblVerify().setText("Se ha agregado con exito al empleado");
                                }
                            }
                        
                            break;
                    }
                }
                catch(NumberFormatException f){
                    FrmAgregarEmpleado.getLblVerify().setText("Ha ingresado incorrectamente los datos");
                }
                
            }else{
                FrmAgregarEmpleado.getLblVerify().setText("Llene todos los campos solicitados");
            }
        }
        
        if (e.getSource()==FrmCasoSeguridad.getBtnCancelarSeguridad()) {
            FrmCasoSeguridad.setVisible(false);
        }else if (e.getSource()==FrmCasoSeguridad.getBtnAgregarSeguridad()){
            FrmCasoVendedor.setVisible(false);
        }
        
        if (e.getSource()==FrmCasoAdministrador.getBtnCancelarAdministrador()) {
            FrmCasoAdministrador.setVisible(false);
        }
        
        if (e.getSource()==FrmCasoVendedor.getBtnCancelarVe()) {
            FrmCasoVendedor.setVisible(false);
        }else if (e.getSource()==FrmCasoVendedor.getBtnAgregarVendedor()) {
                //se agrega
                FrmCasoVendedor.setVisible(false);
        }
        //EliminarEmpleado
        if (e.getSource()==FrmMenuEmpleados.getBtnEliminarEmpleado()) {
            FrmEliminarEmpleado.setVisible(true);
        }
        
        if (e.getSource()==FrmEliminarEmpleado.getBtnEliminar()) {
            if (!FrmEliminarEmpleado.getTxtCedula().getText().equals(" ")) {
                try{
                    boolean eliminar = false;
                    long cedula = Long.parseLong(FrmEliminarEmpleado.getTxtCedula().getText());
                    for (int i = 0; i < empleados.size(); i++) {
                        if (cedula == empleados.get(i).getCedula()) {
                            eliminar = true;
                            empleados.remove(i);
                            FrmEliminarEmpleado.getLblVerify().setText("Se ha eliminado al empleado");
                            break;
                        }                
                    }
                    if (!eliminar) {
                        FrmEliminarEmpleado.getLblVerify().setText("No existe un empleado con esta cédula");
                    }
                }
                catch(NumberFormatException f){
                    FrmEliminarEmpleado.getLblVerify().setText("Se han ingresado incorrectamente los datos");
                }
                
                
            }
            else{
                FrmEliminarEmpleado.getLblVerify().setText("Llene el campo solicitado de cédula");
            }
        }
        
        if (e.getSource()==FrmEliminarEmpleado.getBtnCancelar()) {
            FrmEliminarEmpleado.setVisible(false);
            FrmEliminarEmpleado.getLblVerify().setText("");
            FrmEliminarEmpleado.getTxtCedula().setText("");
        }
        if (e.getSource()==FrmEliminarEmpleado.getBtnVolver()) {
            FrmMprincipal.setVisible(true);
            FrmEliminarEmpleado.setVisible(false);
            FrmMenuEmpleados.setVisible(false);
            FrmEliminarEmpleado.getLblVerify().setText("");
            FrmEliminarEmpleado.getTxtCedula().setText("");
        }
        //Registrar
        if (e.getSource()==FrmMenuEmpleados.getBtnRegistro()) {
            FrmEntraSale.setVisible(true);
        }
        if (e.getSource()==FrmEntraSale.getBtnCancelar()) {
            FrmEntraSale.setVisible(false);
            FrmEntraSale.getLblVerify().setText("");
            FrmEntraSale.getTxtCedula().setText("");
        }
        if (e.getSource()==FrmEntraSale.getBtnVolver()) {
            FrmMprincipal.setVisible(true);
            FrmEntraSale.setVisible(false);
            FrmMenuEmpleados.setVisible(false);
            FrmEntraSale.getLblVerify().setText("");
            FrmEntraSale.getTxtCedula().setText("");
        }
        if (e.getSource()==FrmEntraSale.getBtnRegistrar()) {
            if (!FrmEntraSale.getTxtCedula().getText().equals("")) {
                try{
                    boolean existe = false;
                    long cedula = Long.parseLong(FrmEntraSale.getTxtCedula().getText());
                    int pos = 0;
                    if (empleados.isEmpty()) {
                        FrmEntraSale.getLblVerify().setText("No se ha registrado ningun empleado aun");
                    }
                    else{
                        for (int i = 0; i < empleados.size(); i++) {
                            if (cedula == empleados.get(i).getCedula()) {
                                empleados.get(i).setEstancia(empleados.get(i).registrarEndtradaSalida());                            
                                pos = i;
                                existe = true;
                                break;
                            }
                        }
                        if (!existe) {
                            FrmEntraSale.getLblVerify().setText("No existe un empleado con esta cédula");
                        }
                        else{
                            if (empleados.get(pos).getEstancia()) {
                                FrmEntraSale.getLblVerify().setText("Se ha registrado el ingreso del empleado");
                            }
                            else{
                                FrmEntraSale.getLblVerify().setText("Se ha registrado la salida del empleado");
                            }
                        }
                    }
                }
                catch(NumberFormatException f){
                    FrmEntraSale.getLblVerify().setText("Ha ingresado incorrectamente la cédula");
                }
                
            }else{
                FrmEntraSale.getLblVerify().setText("Empleado no encontrado");
            }
        }
        //Calcular
        if (e.getSource()==FrmMenuEmpleados.getBtnCalcular()) {
            FrmCalcular.setVisible(true);
        }
        if (e.getSource()==FrmCalcular.getBtnVolver()) {
            FrmMprincipal.setVisible(true);
            FrmCalcular.setVisible(false);
            FrmMenuEmpleados.setVisible(false);
            FrmCalcular.getLblVerify().setText("");
            FrmCalcular.getTxtCedula().setText("");
            FrmCalcular.getTxtCantHoras().setText("");
        }
        if (e.getSource()==FrmCalcular.getBtnCancelar()) {
            FrmCalcular.setVisible(false);
            FrmCalcular.getLblVerify().setText("");
            FrmCalcular.getTxtCedula().setText("");
            FrmCalcular.getTxtCantHoras().setText("");
        }
        if (e.getSource()==FrmCalcular.getBtnCalcular()) {
            if (!FrmCalcular.getTxtCedula().getText().equals("")&&!FrmCalcular.getTxtCantHoras().getText().equals("")) {
                try{
                    boolean existe = false;
                 int salario = 0;
                    long cedula = Long.parseLong(FrmCalcular.getTxtCedula().getText());
                    for (int i = 0; i <empleados.size() ; i++) {
                        if (cedula == empleados.get(i).getCedula()) {                        
                            empleados.get(i).calcularSalario(Integer.parseInt(FrmCalcular.getTxtCantHoras().getText()),empleados.get(i).getSalario());
                            salario = empleados.get(i).calcularSalario(Integer.parseInt(FrmCalcular.getTxtCantHoras().getText()),empleados.get(i).getSalario());
                            existe = true;
                        }
                    }
                    if (existe) {
                        FrmCalcular.getLblVerify().setText("El salario del empleado es: " + salario);
                    }
                    else{
                        FrmCalcular.getLblVerify().setText("No existe un empleado con esta cedula");
                    }
                }
                catch(NumberFormatException f){
                    FrmCalcular.getLblVerify().setText("Se han ingresado incorrectamente los datos");
                }
                
            }else{
                FrmCalcular.getLblVerify().setText("Llene todos los espacios correspondientes");
            }
        }
        
        if (e.getSource()==FrmMenuLocales.getBtnListaLocales()) {
            if (locales.isEmpty()) {
                FrmListaLocales.getTxtaListaLocales().setText("No se ha registrado ningún local");
            }
            else{
                for (int i = 0; i < locales.size(); i++) {
                    FrmListaLocales.getTxtaListaLocales().append(locales.get(i).toString()+"\n");
                }
            }
            FrmListaLocales.setVisible(true);
            
        }
        
        if (e.getSource()==FrmListaLocales.getBtnVolver()) {
            FrmListaLocales.setVisible(false);
            FrmListaLocales.getTxtaListaLocales().setText("");
        }
        
        if (e.getSource()==FrmMenuEmpleados.getBtnListaEmpleados()) {
            if (empleados.isEmpty()) {
                FrmListaEmpleados.getTxtaListaEmpleados().setText("No se ha registrado ningún empleado");
            }
            else{
                for (int i = 0; i < empleados.size(); i++) {
                    FrmListaEmpleados.getTxtaListaEmpleados().append(empleados.get(i).toString()+"\n");
                }
            }
            FrmListaEmpleados.setVisible(true);
        }
        
        if (e.getSource()==FrmListaEmpleados.getBtnVolver()) {
            FrmListaEmpleados.setVisible(false);
            FrmListaEmpleados.getTxtaListaEmpleados().setText("");
        }
    }
    
}
