import 'package:flutter/material.dart';
import 'package:flutter_04_componentes/Theme/AppTheme.dart';
import 'Screens/pages.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Material App',
      initialRoute: 'home',
      routes: {
        'home' : (context) => HomePage(),
        'card' : (context) => Card_Page(),
        'alert': (context) => AlertPage(),
        'list1': (context) => ListView1Page(),
        'list2': (context) => ListView2Page(),
        'form': (context) => FormularioPage(),
        'avatar': (context) => AvatarPage(),
        'slider': (context) => Slider_page()
      },
      theme: AppTheme.lightTheme ,
    );
  }
}
