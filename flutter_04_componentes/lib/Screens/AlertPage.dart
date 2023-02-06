import 'dart:js';

import 'package:flutter/material.dart';

class AlertPage extends StatelessWidget {
  AlertPage({super.key});

void mostrarAlerta(BuildContext context){
  showDialog(barrierDismissible: true, context: context, builder: ((context){
    return AlertDialog(
        elevation: 5,
        title: const Text('titulo'),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          children: const [
            Text("Este es el contenido de la alerta"),
            SizedBox(
              height: 10,
            ),
            FlutterLogo(
              size: 100,
            )
          ],
        ),
      actions: [
        TextButton(onPressed: () => Navigator.pop(context), child: const Text("textico"))
      ],

    );
  }));
}


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: ElevatedButton(
            onPressed: () {
              mostrarAlerta(context);
            },
            child: const Padding(
              padding: EdgeInsets.symmetric(horizontal: 20, vertical: 15),
              child: Text("Mostrar alerta"),
            ) 
        ),
      ),
      floatingActionButton: FloatingActionButton(
        child: const Icon(Icons.add_location),
        onPressed: () {
          Navigator.pop(context);
        },
      ),
    );
  }
}
