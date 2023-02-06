import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class tarjeta_personalizada_2 extends StatelessWidget {
  const tarjeta_personalizada_2({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      elevation: 10,
      child: Column(
        children: const [
          FadeInImage(
            image: NetworkImage(
                "https://img.freepik.com/free-vector/nature-scene-with-river-hills-forest-mountain-landscape-flat-cartoon-style-illustration_1150-37326.jpg"),
            placeholder: AssetImage('assets/jar-loading.gif'),
            fadeInDuration: Duration(milliseconds: 300),
            height: 300.0,
            fit: BoxFit.cover,
          )
        ],
      ),
    );
  }
}
