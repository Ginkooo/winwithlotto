from django.test import TestCase
from django.contrib.auth import get_user_model


class AuthTests(TestCase):

    def test_can_sign_up(self):
        self.client.post('/api/sign_up/', {'username': 'test', 'password': 's3cr3t'})
        self.assertEqual(1, get_user_model().objects.all().count())

    def test_can_get_token(self):
        get_user_model().objects.create_user(username='test', password='test')
        resp = self.client.post('/api/get_token/', {'username': 'test', 'password': 'test'})
        self.assertIn('token', resp.json())
