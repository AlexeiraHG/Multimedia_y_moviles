import 'package:flutter/material.dart';
import 'package:flutter_04_componentes/widgets/custom_input_widget.dart';

class FormularioPage extends StatelessWidget {
  const FormularioPage({super.key});

  @override
  Widget build(BuildContext context) {
    

    final GlobalKey<FormState> myFormKey = GlobalKey<FormState>();
    
    final Map<String, String> resultadosForm = {
      'Nombre':'Alex',
      'Apellido':'Heredia',
      'email':'gahg0109@iesch.org',
      'password':'Admin1234',
      'rol':'Admin'
    };
    
    
        return Scaffold(
      appBar: AppBar(title: const Text('Formulario')),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 10),
          child: Form(
            key: myFormKey,
            child: Column(
              children:  [
                CustomInputWidget(
                  labelText: 'Nombre',
                  hintText: 'Nombre del usuario',
                  icon: Icons.verified_user_outlined,
                  formProperty: 'nombre',
                  formValues: resultadosForm,
                ),
                const SizedBox(
                  height: 30,
                ),
                CustomInputWidget(
                  labelText: 'Apellido',
                  hintText: 'Apellido del usuario',
                  icon: Icons.verified_user_outlined,
                  formProperty: 'apellido',
                  formValues: resultadosForm,
                ),
                const SizedBox(
                  height: 30,
                ),
                CustomInputWidget(
                  labelText: 'Correo',
                  hintText: 'Correo del usuario',
                  icon: Icons.email_outlined,
                  suffixIcon: Icons.email_outlined,
                  teclado: TextInputType.emailAddress,
                  formProperty: 'email',
                  formValues: resultadosForm,
                ),
                const SizedBox(
                  height: 30,
                ),
                CustomInputWidget(
                  labelText: 'Contraseña',
                  hintText: 'Password del usuario',
                  icon: Icons.password_outlined,
                  obscureText: true,
                  formProperty: 'password',
                  formValues: resultadosForm,
                ),
                const SizedBox(
                  height: 30,
                ),
          
                //Dropdown seleccionable
                DropdownButtonFormField(
                  value: 'Admin',
                  items: const[
                    DropdownMenuItem(value: 'Admin', child: Text('Admin')),
                    DropdownMenuItem(value: 'SuperUser', child: Text('Super usuario')),
                    DropdownMenuItem(value: 'Developer', child: Text('Developer')),
                    DropdownMenuItem(value: 'JRDeveloper', child: Text('JRDeveloper')),
                  ],
                  onChanged: (valor){    
                    print(valor);
                    //se lo asigno a mi resultado
                    resultadosForm['rol']=valor?? 'Admin';
                  }
                ),

                //Coton para enviar formulario
                ElevatedButton(
                  onPressed: (){
                    //para que desaparezca el teclado
                    FocusScope.of(context).requestFocus(FocusNode());

                    if  (!myFormKey.currentState!.validate()){
                      print('Formulario NO válido');
                      return;
                    }

                    print(resultadosForm);
                  }, 
                  child: const Center(
                    child: Text('Guardar'),
                )
                )
          
              ],
            ),
          ),
        ),
      ),
    );
  }
}
