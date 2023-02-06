import 'package:flutter/material.dart';
import 'package:flutter_04_componentes/Screens/pages.dart';

import '../widgets/tarjeta_personalizada_1.dart';

class Card_Page extends StatelessWidget {
  Card_Page({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text('Cards - Tarjetas'),
          elevation: 0,
        ),
        body: ListView(
          padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 10),
          children: const [
            TarjetaPersonalizada1(),
            SizedBox(
              height: 10,
            ),
            TarjetaPersonalizada2(
              comentario: 'klk',
              imageUrl:
                  'https://images.pexels.com/photos/2662116/pexels-photo-2662116.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
            ),
            SizedBox(
              height: 10,
            ),
            TarjetaPersonalizada2(
              imageUrl:
                  'https://fotoarte.com.uy/wp-content/uploads/2019/03/Landscape-fotoarte.jpg',
            ),
            SizedBox(
              height: 10,
            ),
            TarjetaPersonalizada2(
              comentario: 'another commet',
              imageUrl:
                  'https://www.nyip.edu/images/cms/photo-articles/the-best-place-to-focus-in-a-landscape.jpg',
            ),
            SizedBox(
              height: 10,
            ),
            TarjetaPersonalizada2(
              imageUrl:
                  'https://cdn3.dpmag.com/2021/07/Landscape-Tips-Mike-Mezeul-II.jpg',
            ),
          ],
        ));
  }
}
