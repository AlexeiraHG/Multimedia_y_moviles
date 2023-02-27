import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter_07_firebase_storage/services/imagen_service.dart';
import 'package:image_picker/image_picker.dart';
import 'package:photo_view/photo_view.dart';

import '../services/upload_images.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  File? imagen_a_subir;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        elevation: 0,
        title: const Text("Firebase Storage"),
      ),
      body: Column(children: [
        imagen_a_subir != null
            ? Image.file(imagen_a_subir!)
            : Container(
                height: 200,
                width: double.infinity,
                margin: EdgeInsets.all(10),
                color: Colors.greenAccent,
              ),
        ElevatedButton(
            onPressed: () async {
              final XFile? imagen = await getImage();
              setState(() {
                imagen_a_subir = File(imagen!.path);
              });
            },
            child: Text("Seleccionar imagen")),
        ElevatedButton(
            onPressed: () async {
              if (imagen_a_subir == null) {
                return;
              }
              final uploaded = await uploadImage(imagen_a_subir!);

              if (uploaded) {
                ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
                    content: Text("Imagen subida correctamente.")));
              } else {
                ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
                    content: Text("Error al subir la imagen.")));
              }
            },
            child: Text("Subir imagen a Firebase")),
      ]),
    );
  }
}
