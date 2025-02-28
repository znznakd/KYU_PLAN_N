Map<String, String> map = new HashMap<>();

map.put("K3", "V3");
map.put("K1", "V1");
map.put("K2", "V2");

// Case 1
Iterator<String> keys = map.keySet().iterator();
while (keys.hasNext()) {
    String key = keys.next();
    System.out.println(key + " " + map.get(key));
}

// Case 2
for (Map.Entry<String, String> elem : map.entrySet()) {
    System.out.println(elem.getKey() + " " + elem.getValue());
}

// Case 3
for (String key : map.keySet()) {
    System.out.println(key + " " + map.get(key));
}

// Output - 3가지 방법 다 동일
K2 V2
K1 V1
K3 V3
