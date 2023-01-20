import 'package:json_annotation/json_annotation.dart';

part 'sort_response.g.dart';

@JsonSerializable()
class SortResponse {
  SortResponse({
    required this.algorithm,
    required this.data,
    required this.time,
  });

  factory SortResponse.fromJson(Map<String, dynamic> json) =>
      _$SortResponseFromJson(json);

  final String algorithm;
  final List<dynamic> data;
  final String time;

  Map<String, dynamic> toJson() => _$SortResponseToJson(this);
}
