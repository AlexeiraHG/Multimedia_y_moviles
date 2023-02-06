import 'package:flutter/material.dart';
import 'package:flutter_05_apirest/models/post.dart';

import '../services/post_service.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  List<Post>? listadePosts;
  bool isLoaded = false;

  @override
  void initState() {
    super.initState();

    //llamamos a obtener los posts
    obtenerPosts();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        elevation: 0,
        title: const Text('Posts'),
      ),
      body: Visibility(
        visible: isLoaded,
        replacement: const Center(
          child: CircularProgressIndicator(),
        ),
        child: ListView.builder(
            itemCount: listadePosts?.length,
            itemBuilder: ((context, index) {
              return Container(
                padding: const EdgeInsets.all(16),
                child: Row(
                  children: [
                    Container(
                        height: 50,
                        width: 50,
                        //esto es el cuadrito gris
                        decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(12),
                            color: Colors.grey[300])),
                    const SizedBox(
                      width: 16,
                    ),
                    Expanded(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            listadePosts![index].title,
                            maxLines: 2,
                            overflow: TextOverflow.ellipsis,
                            style: TextStyle(
                                fontSize: 24, fontWeight: FontWeight.bold),
                          ),
                          Text(
                            listadePosts![index].body ?? '',
                          )
                        ],
                      ),
                    )
                  ],
                ),
              );
            })),
      ),
    );
  }

  obtenerPosts() async {
    listadePosts = await PostService().getPost();
    if (listadePosts != null) {
      setState(() {
        isLoaded = true;
      });
    }
  }
}
