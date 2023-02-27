// File generated by FlutterFire CLI.
// ignore_for_file: lines_longer_than_80_chars, avoid_classes_with_only_static_members
import 'package:firebase_core/firebase_core.dart' show FirebaseOptions;
import 'package:flutter/foundation.dart'
    show defaultTargetPlatform, kIsWeb, TargetPlatform;

/// Default [FirebaseOptions] for use with your Firebase apps.
///
/// Example:
/// ```dart
/// import 'firebase_options.dart';
/// // ...
/// await Firebase.initializeApp(
///   options: DefaultFirebaseOptions.currentPlatform,
/// );
/// ```
class DefaultFirebaseOptions {
  static FirebaseOptions get currentPlatform {
    if (kIsWeb) {
      return web;
    }
    switch (defaultTargetPlatform) {
      case TargetPlatform.android:
        return android;
      case TargetPlatform.iOS:
        return ios;
      case TargetPlatform.macOS:
        return macos;
      case TargetPlatform.windows:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for windows - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      case TargetPlatform.linux:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for linux - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      default:
        throw UnsupportedError(
          'DefaultFirebaseOptions are not supported for this platform.',
        );
    }
  }

  static const FirebaseOptions web = FirebaseOptions(
    apiKey: 'AIzaSyCBiZmIJqO34lsHTh6kBi4BrTHaYBwOrUc',
    appId: '1:764321233056:web:e1d459291dbd62476871c5',
    messagingSenderId: '764321233056',
    projectId: 'flutterproje-4a8a3',
    authDomain: 'flutterproje-4a8a3.firebaseapp.com',
    storageBucket: 'flutterproje-4a8a3.appspot.com',
    measurementId: 'G-21ZEYL258H',
  );

  static const FirebaseOptions android = FirebaseOptions(
    apiKey: 'AIzaSyBKHbtf-2It-H2mwuS51NopYsuPiEo-hQI',
    appId: '1:764321233056:android:90922ec7e201bf9f6871c5',
    messagingSenderId: '764321233056',
    projectId: 'flutterproje-4a8a3',
    storageBucket: 'flutterproje-4a8a3.appspot.com',
  );

  static const FirebaseOptions ios = FirebaseOptions(
    apiKey: 'AIzaSyAh19wdHbMvlGtt_Kkg5f3Ha_uqtNQGik8',
    appId: '1:764321233056:ios:40c9af44499955626871c5',
    messagingSenderId: '764321233056',
    projectId: 'flutterproje-4a8a3',
    storageBucket: 'flutterproje-4a8a3.appspot.com',
    iosClientId: '764321233056-rt290855tn5vb4bfij3b72roer09ka2c.apps.googleusercontent.com',
    iosBundleId: 'com.iesch.org.flutter06Firebasecrud',
  );

  static const FirebaseOptions macos = FirebaseOptions(
    apiKey: 'AIzaSyAh19wdHbMvlGtt_Kkg5f3Ha_uqtNQGik8',
    appId: '1:764321233056:ios:40c9af44499955626871c5',
    messagingSenderId: '764321233056',
    projectId: 'flutterproje-4a8a3',
    storageBucket: 'flutterproje-4a8a3.appspot.com',
    iosClientId: '764321233056-rt290855tn5vb4bfij3b72roer09ka2c.apps.googleusercontent.com',
    iosBundleId: 'com.iesch.org.flutter06Firebasecrud',
  );
}