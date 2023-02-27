import 'dart:io';
import 'package:firebase_storage/firebase_storage.dart';

final FirebaseStorage storage = FirebaseStorage.instance;

Future<bool> uploadImage(File imagen) async {
  print("Ruta de la imagen: " + imagen.path);

  //division del nombre de la imagen de la ruta del archivo y nos quedamos con la ultima
  final String nombreImagen = imagen.path.split('/').last;

  final Reference ref = storage.ref().child('imagenes').child('alberto').child(nombreImagen);
  final UploadTask uploadTask = ref.putFile(imagen);
  print(uploadTask);

  final TaskSnapshot snapshot = await uploadTask.whenComplete(() => true);
  pragma(snapshot.toString());

  //obetener url del archivo subido al storage en internet
  final String url = await snapshot.ref.getDownloadURL();
  pragma(url);

  return false;
}
