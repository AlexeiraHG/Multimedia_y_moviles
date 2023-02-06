import 'package:flutter/material.dart';

class Slider_page extends StatefulWidget {
  const Slider_page({super.key});

  @override
  State<Slider_page> createState() => _Slider_pageState();
}

class _Slider_pageState extends State<Slider_page> {

  double _sliderValor = 100;



  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('SliderPage')),
      body: Column(children: [
        Slider.adaptive(
          min: 50,
          max: 400,
          value: _sliderValor,
         onChanged: ((value){
          _sliderValor = value;
          setState(() {});
         })),
        Expanded(
            child: SingleChildScrollView(          
              child: Image(
                image: NetworkImage('https://pbs.twimg.com/media/FDyRpc9WQAAsERJ?format=jpg&name=large'),
                  fit: BoxFit.contain,
                  width: _sliderValor,),                    
                 ),
          ),
      const SizedBox(

      )
      ]),
    );
  }
}