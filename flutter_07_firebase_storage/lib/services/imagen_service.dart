// agregar import de image_picker
import 'package:image_picker/image_picker.dart';

Future<XFile?> getImage() async {
  final ImagePicker picker = ImagePicker();

  //Seleccionar una imagen de la galería
  final XFile? image = await picker.pickImage(source: ImageSource.gallery);

  return image;
 
}


