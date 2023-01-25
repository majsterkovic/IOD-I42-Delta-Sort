import 'package:dio/dio.dart';

import 'models/models.dart';
export 'models/models.dart';

class SortApi {
  factory SortApi() {
    return _instance;
  }

  SortApi._sortApi() {
    dio.options.headers['content-Type'] = 'application/json';
    dio.options.headers['accept'] = 'application/json';
    dio.options.baseUrl = 'http://127.0.0.1:8080/api';
  }

  static final SortApi _instance = SortApi._sortApi();

  final Dio dio = Dio();

  Future<List<SortResponse>> simpleSort(SimpleSortRequest request) async {
    final response = await dio.post(
      '/simplearray',
      data: request.toJson(),
    );
    final List<dynamic> data = response.data;
    return data.map((e) => SortResponse.fromJson(e)).toList();
  }

  Future<List<SortResponse>> objectSort(ObjectSortRequest request) async {
    final response = await dio.post(
      '/objectarray',
      data: request.toJson(),
    );
    final List<dynamic> data = response.data;
    return data.map((e) => SortResponse.fromJson(e)).toList();
  }
}
