## Homepage

https://jvecom11.herokuapp.com

Or: https://ec18a002.herokuapp.com (Always on)

## API 1

http://mydomain.local/rest/image/quantity

U can test here: https://jvecom11.herokuapp.com/rest/image/quantity

Or here: https://ec18a002.herokuapp.com/rest/image/quantity

HTTP Method: GET

Response: Body: --Number of images-- (Example: 3)

---

## API 2

http://mydomain.local/rest/image/2

U can test here: https://jvecom11.herokuapp.com/rest/image/2

Or here: https://ec18a002.herokuapp.com/rest/image/2

HTTP Method: GET

Response: Body: --Image with index = 2-- (index in range (0, n) with n is number of images)

---

## API 3

http://mydomain.local/rest/file/upload

U can test here: https://jvecom11.herokuapp.com/rest/file/upload

Or here: https://ec18a002.herokuapp.com/rest/file/upload

HTTP Method: POST

Request: Body: --Image to upload--

---

## API 4

U can test here: https://ec18a002.herokuapp.com/rest/image/filename/0

HTTP Method: GET

Response: JSON: filename

With 0 is id (same as API 2)

## API 5

U can test here: https://jvecom11.herokuapp.com/rest/file/uploadjson

HTTP Method: POST

Request: Body:

```JSON
{
  "title": "Mèo",
  "src": "89asdfjcAJIG9a"
 }
```