import 'package:flutter/material.dart';

class ListView2Page extends StatelessWidget {
  ListView2Page({super.key});

  final opciones = [
    "Polaris",
    "Batman",
    "Spiderman",
    "Lovemess",
    "El Alfa",
    "Loba",
    "Polaris",
    "Batman",
    "Spiderman",
    "Lovemess",
    "El Alfa",
    "Loba",
    "Polaris",
    "Batman",
    "Spiderman",
    "Lovemess",
    "El Alfa",
    "Loba",
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.purple,
          title: const Text("Componentes"),
          elevation: 0,
        ),
        body: ListView.separated(
          itemCount: opciones.length,
          itemBuilder: ((context, index) {
            return ListTile(
              leading: const Icon(
                Icons.child_care_outlined,
                color: Colors.purple,
              ),
              title: Text(opciones[index]),
              subtitle: Text(opciones[index]),
              trailing: const Icon(
                Icons.arrow_forward_ios_outlined,
                color: Colors.purple,
              ),
              onTap: () {
                final superhero = opciones[index];
                print(superhero);
              },
            );
          }),
          separatorBuilder: ((_, __) => const Divider()),
        ));
  }
}
