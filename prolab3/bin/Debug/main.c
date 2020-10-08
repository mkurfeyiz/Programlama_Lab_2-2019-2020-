#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
/*þehrin ismi, plaka kodu, hangi bölgede
olduðu ve bu þehirden direk ulaþýlabilen
(komþu) þehirler.

Dugum yapisi :

- 1. tip (þehir) düðüm yapýsýnda her bir þehir için plaka kodu (int), þehir adý (string), ait olduðu coðrafi
bölge (string) ve komþu sayýsý (int) bilgileri tutulmalýdýr.
- 2.tip (komþu) düðüm yapýsýnda her þehir için komþu þehirlerin plaka kod (int) bilgilerini ardýþýk olarak
tutulmalýdýr.

*/

struct Sehir
{
    int plaka;
    char *sehirAdi;
    char *bolge;
    int komsuSayisi;
    struct Sehir* sonrakiSehir;
    struct Komsu* komsu;
};

struct Komsu
{
    int plaka;
    struct Komsu* komsu;
};

void printList(struct Sehir *n)
{
    while (n != NULL)
    {
        printf("Sehir Adi : %s / Plaka Kodu : %d / Bulundugu Bolge : %s\n", n->sehirAdi,n->plaka,n->bolge);
        n = n->sonrakiSehir;
    }
}

void dosyadanOku(FILE *fp,char satir[])
{
    fp=fopen("sehirler.txt","r");
    int plaka[100];
    char *ayrilan;
    int sayac=0,i=0;
    while(fgets(satir,250,fp))
    {
        printf("%s",satir);
        ayrilan=strtok(satir,",");
        while(ayrilan!=NULL)
        {
            printf("%s\n",ayrilan);
            plaka[i]=atoi(ayrilan);
            i++;
            ayrilan=strtok(NULL,",");
        }
        sayac++;
    }
    fclose(fp);
}

void sona_ekle(struct Sehir** yeniRef, struct Komsu** yeniKomsu,int plaka,char sehirAdi[],char bolge[])
{
    /* 1. yeni dugum için yer al */
    struct Sehir* yeni_dugum = (struct Sehir*) malloc(sizeof(struct Sehir));
    struct Sehir* sonuncu = *yeniRef;
    /* 2. yeni dugume yeni veri */
    yeni_dugum->plaka = plaka;
    yeni_dugum->sehirAdi = sehirAdi;
    yeni_dugum->bolge = bolge;
    yeni_dugum->komsu = yeniKomsu;
    yeni_dugum->sonrakiSehir = NULL;
    /* 3. Eðer liste boþsa */
    if (*yeniRef == NULL)
    {
        *yeniRef = yeni_dugum;
        return;
    }
    /* 4. Boþ deðilse son düðüme kadar git */
    while (sonuncu->sonrakiSehir != NULL)
        sonuncu = sonuncu->sonrakiSehir;
    /* 5. sonuncuya kadar gittik */
    sonuncu->sonrakiSehir = yeni_dugum;
    /*fprintf(cikti,"Sona Eklenen Sehrin Bilgileri \n");
    fprintf(cikti,"Sehir Adi : %s / Plaka Kodu : %d / Bulundugu Bolge : %s\n",sehirAdi,plaka,bolge);*/
    return;
}

void basa_ekle(struct Sehir** birinciRef, struct Komsu** yeniKomsu,int plaka,char sehirAdi[],char bolge[])
{
    /* 1. yeni dugum için yer al */
    struct Sehir* yeni_dugum = (struct Sehir*) malloc(sizeof(struct Sehir));
    /* 2. yeni dugume yeni veri */
    yeni_dugum->plaka = plaka;
    yeni_dugum->sehirAdi = sehirAdi;
    yeni_dugum->bolge = bolge;
    yeni_dugum->komsu = yeniKomsu;
    /* 3. Yeni dugum birinci dugum olmalý */
    yeni_dugum->sonrakiSehir = (*birinciRef);
    (*birinciRef) = yeni_dugum;
    /*fprintf(cikti,"Basa Eklenen Sehrin Bilgileri \n");
    fprintf(cikti,"Sehir Adi : %s / Plaka Kodu : %d / Bulundugu Bolge : %s\n",sehirAdi,plaka,bolge);*/
}

void araya_ekle(struct Sehir* oncekiSehir, struct Komsu** yeniKomsu,int plaka,char sehirAdi[],char bolge[])
{
    /*1. onceki dugum NULL mu? */
    if (oncekiSehir == NULL)
    {
        printf("onceki dugum NULL olmamalý!");
        return;
    }
    /* 2. yeni dugum için yer al */
    struct Sehir* yeni_dugum =(struct Sehir*) malloc(sizeof(struct Sehir));
    /* 3. yeni dugume yeni veri */
    yeni_dugum->plaka = plaka;
    yeni_dugum->sehirAdi = sehirAdi;
    yeni_dugum->bolge = bolge;
    yeni_dugum->komsu = yeniKomsu;
    /* 4. yeni dugum araya al */
    yeni_dugum->sonrakiSehir = oncekiSehir->sonrakiSehir;
    oncekiSehir->sonrakiSehir = yeni_dugum;
    /*fprintf(cikti,"Araya Eklenen Sehrin Bilgileri \n");
    fprintf(cikti,"Sehir Adi : %s / Plaka Kodu : %d / Bulundugu Bolge : %s\n",sehirAdi,plaka,bolge);*/
}
//BUNUNLA ILGILEN
void deleteNode(struct Node **head_ref, int key)
{
    // Store head node
    struct Node* temp = *head_ref, *prev;

    // If head node itself holds the key to be deleted
    if (temp != NULL && temp->data == key)
    {
        *head_ref = temp->next;   // Changed head
        free(temp);               // free old head
        return;
    }

    // Search for the key to be deleted, keep track of the
    // previous node as we need to change 'prev->next'
    while (temp != NULL && temp->data != key)
    {
        prev = temp;
        temp = temp->next;
    }

    // If key was not present in linked list
    if (temp == NULL) return;

    // Unlink the node from linked list
    prev->next = temp->next;

    free(temp);  // Free memory
}

void sehirAra(struct Sehir* n,int arananPlaka,char arananSehir[])
{
    bool kontrol = false;
    while(n!=NULL)
    {
        if(n->plaka == arananPlaka && strcmp(n->sehirAdi,arananSehir))
        {
            printf("Sehir Adi : %s / Plaka Kodu : %d / Bulundugu Bolge : %s\n", n->sehirAdi,n->plaka,n->bolge);
            kontrol = true;

        }
        n=n->sonrakiSehir;
    }
    if(kontrol == false)
    {
        int secim;
        struct Komsu* yeniKomsu=NULL;
        printf("Aradiginiz sehir listede bulunamadi.Aradiginiz sehri eklemek ister misiniz?\n");
        printf("Eklemek icin 1,iptal etmek icin 2 giriniz\n");
        scanf("%d",&secim);
        switch(secim)
        {
        case 1:
            sona_ekle(&n,&yeniKomsu,arananPlaka,arananSehir,NULL);
            printf("Sehir Eklendi!\n");
            break;
        case 2:
            printf("Sehir eklemesi iptal edildi\n");
            break;
        default:
            printf("Yanlis bir secim yaptiniz\n");
            break;
        }
    }
    else
    {
        printf("Islem tamamlandi\n");
    }
}

int main()
{
    struct Sehir* deneme=NULL;
    struct Komsu* komsu=NULL;
    char sehirAdi[15]="Istanbul";
    char bolge[5]="MA";
    int plaka=34;
    FILE *fp,*cikti=fopen("cikti.txt","w");
    char satir[250];
    dosyadanOku(&fp,satir);
    printf("\n");
    basa_ekle(&deneme,&komsu,plaka,sehirAdi,NULL);
    sona_ekle(&deneme,&komsu,plaka,sehirAdi,bolge);
    sona_ekle(&deneme,&komsu,plaka,sehirAdi,bolge);
    //sehirAra(&deneme,53,"Rize"); //sehri istanbul bile girsem bulunamadi hatasi veriyor!
    printList(deneme);
    fclose(cikti);
    return 0;
}


