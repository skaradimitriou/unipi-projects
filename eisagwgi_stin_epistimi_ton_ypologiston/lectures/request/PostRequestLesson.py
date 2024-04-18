import requests

user = {
    'name': 'Stathis',
    'job': 'Developer'
}

# POST Request
postRequest = requests.post('https://reqres.in/api/users', data=user)

print(postRequest.status_code)
print(postRequest.text)