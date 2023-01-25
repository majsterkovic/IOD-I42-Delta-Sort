// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'sort_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

SortResponse _$SortResponseFromJson(Map<String, dynamic> json) => SortResponse(
      algorithm: json['algorithm'] as String,
      data: json['data'] as List<dynamic>,
      time: json['time'] as String,
    );

Map<String, dynamic> _$SortResponseToJson(SortResponse instance) =>
    <String, dynamic>{
      'algorithm': instance.algorithm,
      'data': instance.data,
      'time': instance.time,
    };
