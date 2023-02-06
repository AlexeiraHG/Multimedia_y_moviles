import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text("Flutter componentes"),
          elevation: 0,
        ),
        body: ListView(
          children: [
            ListTile(
              title: Text("Listas de tipo 1"),
              leading: const Icon(Icons.account_balance_wallet),
              trailing: const Icon(Icons.keyboard_arrow_right),
              onTap: (() => Navigator.pushNamed(context, 'list1')),
            ),
            const Divider(),
            ListTile(
              title: Text("Listas de tipo 2"),
              leading: const Icon(Icons.account_balance_wallet),
              trailing: const Icon(Icons.keyboard_arrow_right),
              onTap: (() => Navigator.pushNamed(context, 'list2')),
            ),
            const Divider(),
            ListTile(
              title: Text("Alerst - Alertas"),
              leading: const Icon(Icons.account_balance_wallet),
              trailing: const Icon(Icons.keyboard_arrow_right),
              onTap: (() => Navigator.pushNamed(context, 'alert')),
            ),
            const Divider(),
            ListTile(
              title: Text("Cards - Tarjetas"),
              leading: const Icon(Icons.account_balance_wallet),
              trailing: const Icon(Icons.keyboard_arrow_right),
              onTap: (() => Navigator.pushNamed(context, 'card')),
            ),
            const Divider(),
            ListTile(
              title: Text("Formulario"),
              leading: const Icon(Icons.abc),
              trailing: const Icon(Icons.keyboard_arrow_right),
              onTap: (() => Navigator.pushNamed(context, 'form')),
            ),
             const Divider(),
            ListTile(
              title: const Text('Avatar'),
              leading: const Icon(Icons.image_rounded),
              trailing: const Icon(Icons.keyboard_arrow_right),
              onTap: () => Navigator.pushNamed(context, 'avatar'),
            ),
            const Divider(),
            ListTile(
              title: const Text('Slider Page'),
              leading: const Icon(Icons.image_rounded),
              trailing: const Icon(Icons.keyboard_arrow_right),
              onTap: () => Navigator.pushNamed(context, 'slider'),
            ),
            const Divider(),
          ],
        ));
  }
}
