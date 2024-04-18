# Get Request
import json
import requests

from request.Monster import Monster

monsterList = []

response = requests.get('https://774906.youcanlearnit.net/feed/monster_data.json')

print('The request code is {0}'.format(response.status_code))
print('')

json_data = json.loads(response.text)

for i in json_data:
    monster = Monster(i['imageFile'], i['monsterName'], i['caption'], i['description'], i['price'], i['scariness'])
    monsterList.append(monster)
    print('Monster: {0}, Price: {1}, Scarines:s {2}, Description: {3}'.format(monster.monsterName, monster.price,
                                                                              monster.scariness, monster.description))

print('')
print('MonsterList contains {0} monsters.'.format(len(monsterList)))