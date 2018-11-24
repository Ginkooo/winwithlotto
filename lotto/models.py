from django.db import models

# Create your models here.


class ScratchType(models.Model):
    name = models.CharField(max_length=255)
