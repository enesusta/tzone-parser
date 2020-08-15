
<div align="center">

**tzone-parser** converts `xlsx` file as listed above to `JSON`

</div>

## Raw data before parsing

<div align="center">

| Province | County | Town/State | Village/Neighbourhood | Zip Code |
|:-:|:-:|:-:|:-:|:-:|
|EDİRNE                        |ENEZ                          |ENEZ                          |ÇATALTEPE MAH                                                              |22700|
|EDİRNE                        |ENEZ                          |ENEZ                          |GAZİÖMERBEY MAH                                                            |22700|
|EDİRNE                        |ENEZ                          |ENEZ                          |YENİ MAH                                                                   |22700|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |ABDURRAHİM KÖYÜ                                                            |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |BÜYÜKEVREN KÖYÜ                                                            |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |ÇANDIR KÖYÜ                                                                |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |ÇAVUŞKÖY KÖYÜ                                                              |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |ÇERİBAŞI KÖYÜ                                                              |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |GÜLÇAVUŞ KÖYÜ                                                              |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |HASKÖY KÖYÜ                                                                |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |HİSARLI KÖYÜ                                                               |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |IŞIKLI KÖYÜ                                                                |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |KARAİNCİRLİ KÖYÜ                                                           |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |KOCAALİ KÖYÜ                                                               |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |KÜÇÜKEVREN KÖYÜ                                                            |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |SULTANİÇE KÖYÜ                                                             |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |SÜTÇÜLER KÖYÜ                                                              |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |ŞEHİTLER KÖYÜ                                                              |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |UMURBEY KÖYÜ                                                               |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |VAKIF KÖYÜ                                                                 |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |YAZIR KÖYÜ                                                                 |22750|
|EDİRNE                        |ENEZ                          |MERKEZKÖYLER                  |YENİCE KÖYÜ                                                                |22750|

</div>

<br/>


## The data parsed by `tzone-parser`

```json
{
   "provinceName":"Edirne",
   "provinceCounties":[
      {
         "countyName":"Enez",
         "countyTowns":[ { 
               "townName":"Enez",
               "townVillages":[
                  { "villageName":"Gaziömerbey mah", "zipCode":22700 },
                  { "villageName":"Yeni mah", "zipCode":22700 },
                  { "villageName":"Çataltepe mah", "zipCode":22700 }
               ]
            },
            {
               "townName":"Merkezköyler",
               "townVillages":[
                  { "villageName":"Abdurrahim köyü", "zipCode":22750 },
                  { "villageName":"Büyükevren köyü", "zipCode":22750 },
                  { "villageName":"Gülçavuş köyü", "zipCode":22750 },
                  { "villageName":"Hasköy köyü", "zipCode":22750 },
                  { "villageName":"Hisarlı köyü", "zipCode":22750 },
                  { "villageName":"Işıklı köyü", "zipCode":22750 },
                  { "villageName":"Karaincirli köyü", "zipCode":22750 },
                  { "villageName":"Kocaali köyü", "zipCode":22750 },
                  { "villageName":"Küçükevren köyü", "zipCode":22750 },
                  { "villageName":"Sultaniçe köyü", "zipCode":22750 },
                  { "villageName":"Sütçüler köyü", "zipCode":22750 },
                  { "villageName":"Umurbey köyü", "zipCode":22750 },
                  { "villageName":"Vakıf köyü", "zipCode":22750 },
                  { "villageName":"Yazır köyü", "zipCode":22750 },
                  { "villageName":"Yenice köyü", "zipCode":22750 },
                  { "villageName":"Çandır köyü", "zipCode":22750 },
                  { "villageName":"Çavuşköy köyü", "zipCode":22750 },
                  { "villageName":"Çeribaşı köyü", "zipCode":22750 },
                  { "villageName":"Şehitler köyü", "zipCode":22750 }
               ]
            }
         ]
      }
   ]
}
```

