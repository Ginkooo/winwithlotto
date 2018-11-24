from django.contrib import admin

from lotto import models

# Register your models here.

admin.site.register(models.User)
admin.site.register(models.Award)
admin.site.register(models.CoinBag)
admin.site.register(models.Scratch)
admin.site.register(models.ScratchGroup)
admin.site.register(models.ScratchType)
