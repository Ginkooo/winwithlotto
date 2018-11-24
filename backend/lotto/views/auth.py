from rest_framework.decorators import api_view
from rest_framework.response import Response
from django.contrib.auth import get_user_model


@api_view(['POST'])
def sign_up(request):
    try:
        username = request.POST['username']
        password = request.POST['password']
    except KeyError as e:
        return Response(str(e), status=400)
    get_user_model().objects.create_user(username=username, password=password)
    return Response(request.POST, status=201)
