import 'package:flutter/material.dart';

class ListView1Page extends StatelessWidget {
  ListView1Page({super.key});

  final opciones = [
    "Polaris",
    "Batman",
    "Spiderman",
    "Lovemess",
    "El Alfa",
    "EL toto",
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text("Componentes"),
          elevation: 0,
        ),
        body: ListView(
          children: [
            ...opciones
                .map((superhero) => ListTile(
                      leading: const Icon(Icons.access_time_sharp),
                      title: Text(superhero),
                      trailing: const Icon(Icons.arrow_forward_ios_outlined),
                    ))
                .toList()
          ],
        ));
  }
}
