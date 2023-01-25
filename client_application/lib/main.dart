import 'package:flutter/material.dart';
import 'package:sort_client/modules/start/start_page.dart';

Future<void> main() async {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Sorting Madness',
      theme: ThemeData(
        primarySwatch: Colors.orange,
      ),
      home: const StartPage(),
    );
  }
}
