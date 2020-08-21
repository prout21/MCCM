package Demo.APIRestful;

public class BODYPART {
	
	
	Please refer Fields In table below. 
	Sample
	/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction
	{
	"parts": {
	"channel": [
	{
	"name": "Online",
	"type": "Inbound"
	}
	],
	"subscription": {
	"id": [
	{
	"value": "3646fe16afebc43654",
	"schemeID": "MobileHashed"
	}
	]
	},
	"campaign": {
	"container": "CustomerOfferOnline"
	},
	"specification": {
	"characteristicsValue": [
	{
	"characteristicName": "Transaction",
	"value": "Prolongation",
	"type": "Intent"
	}
	]
	}
	}
	}


--------------------------BODY OUT----------------
Fields Out	Body
[
{
"name": "MCC_3102;4G_SWAP",
"details": {
"shortDescription": "Angebot Red M Premium Smartphone (Sub25)",
"priorityCode": "1.00",
"issue": "Treatment",
"group": "Web"
},
"roles": {
"subscriber": {
"id": [
{
"value": "1234567",
"schemeID": "Pega"
}
]
}
},
"parts": {
"channel": [
{
"name": "Online",
"type": "Inbound"
}
],
"subscription": {
"id": [
{
"value": "3646fe16afebc43654",
"schemeID": "MobileHashed"
}
]
},
"campaign": {
"id": [
{
"value": "P-241"
}
],
"container": "CustomerOfferOnline"
},
"customerInteraction": [
{
"id": [
{
"value": "-992339829577690452"
}
]
}
]
}
}
]



}
