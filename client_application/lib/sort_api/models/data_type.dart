enum DataType {
  string(name: 'String'),
  double(name: 'Double'),
  int(name: 'Int');

  const DataType({required this.name});

  final String name;
}
