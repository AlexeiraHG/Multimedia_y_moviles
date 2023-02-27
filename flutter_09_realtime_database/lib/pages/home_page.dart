import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

import '../model/user.dart';
import '../widgets/userTile.dart';
import 'AddNewUser_page.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  List<User> _list = [];

//obtenemos los usuarios de realtime
  fetchUsers() async {
    final response = await http.get(Uri.parse(
        "https://flutterproje-4a8a3-default-rtdb.europe-west1.firebasedatabase.app/usuarios.json"));
    final extractedData = jsonDecode(response.body) as Map<String, dynamic>;
    extractedData.forEach((key, value) {
      _list.add(User(
          docId: value["docId"],
          email: value["email"],
          phoneNumber: value["phoneNumber"],
          username: value["username"]));
    });
  }

  @override
  void didChangeDependencies() {
    fetchUsers();
    super.didChangeDependencies();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Real Time Data Base'),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.of(context).push(
            MaterialPageRoute(builder: (_) => const AddNewUserPage()),
          );
        },
        child: const Icon(Icons.add),
      ),
      body: ListView.builder(
        itemBuilder: (context, index) {
          return UserTile(
            user: User(
                username: 'username',
                email: 'email',
                phoneNumber: 'phoneNumber',
                docId: 'docId'),
          );
        },
        itemCount: _list.length,
      ),
    );
  }
}
