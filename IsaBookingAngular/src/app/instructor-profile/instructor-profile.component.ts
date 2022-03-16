import { Component, OnInit } from '@angular/core';
import { Fishing } from '../models/fishing';
import { FishingService } from '../services/fishing.service'
import { AuthenticationService } from '../services/authentication.service';
import { Observable } from 'rxjs';
import { FishingImage } from '../models/fishing-image';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';

@Component({
  selector: 'app-instructor-profile',
  templateUrl: './instructor-profile.component.html',
  styleUrls: ['./instructor-profile.component.css']
})
export class InstructorProfileComponent implements OnInit {
  fishingProfile: Fishing
  fishingImages: FishingImage[]
  selectedFile: File;
  retrievedImage: any;
  
  base64Data: any;
  retrieveResonse: any;
  message: string;
  imageName: any;

  constructor(private fishingService: FishingService,
              private authenticationService: AuthenticationService,
              private httpClient: HttpClient) {
    this.fishingProfile = new Fishing;
    this.fishingImages = [];
    this.message = "";
    this.selectedFile = new File([""], "filename");
    this.GetFishingProfile();
    this.GetFishingProfileGallery();
   }

  ngOnInit(): void {
    this.GetFishingProfile();
    this.GetFishingProfileGallery();
    console.log("ODRADIO", this.fishingProfile.adress)
  }

  GetFishingProfile(){
    this.fishingService.GetFishingProfiles()
      .subscribe((data: any) => {
        for(const d of (data as any)){
          if(this.authenticationService.currentUserValue.id == d.userId){
            this.fishingProfile = d;
          }
      }
    })
  }
  GetFishingProfileGallery(){
    this.fishingService.GetFishingImages()
    .subscribe((data: any) => {
      for(const d of (data as any)){
        if(this.fishingProfile.id == d.fishingClass.id){
          if(!this.ImageAlreadyLoaded(d.id)){
            this.fishingImages.push(d);
          }
        }
      }
      console.log(this.fishingImages)
    })
  }
  ImageAlreadyLoaded(id: number): boolean{
    for(const img of this.fishingImages){
      if(img.id == id){
        return true;
      }
    }
    return false;
  }

  //Gets called when the user selects an image
  public onFileChanged(event: any) {
    //Select File
    this.selectedFile = event.target.files[0];
  }
  //Gets called when the user clicks on submit to upload the image
  onUpload() {
    console.log(this.selectedFile);
    
    const body = {
      file : this.selectedFile,
      fishingId: this.fishingProfile.id
      
    };
    let headers = new HttpHeaders({
      'Content-Type': 'application/json' });
    let options = { headers: headers, observe: 'response' };

    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);
    uploadImageData.append('fishingId', this.fishingProfile.id.toString());
    //Make a call to the Spring Boot Application to save the image
    this.httpClient.post('http://localhost:8081/api/fishingImages/upload', uploadImageData, {observe: 'response'})
      .subscribe((response) => {
        if (response.status === 200) {
          this.message = 'Image uploaded successfully';
        } else {
          this.message = 'Image not uploaded successfully';
        }
      }
      );
  }
    //Gets called when the user clicks on retieve image button to get the image from back end
    getImage() {
    //Make a call to Sprinf Boot to get the Image Bytes.
    this.httpClient.get('http://localhost:8081/api/fishingImages/get/' + this.fishingProfile.id)
      .subscribe(
        res => {
          this.retrieveResonse = res;
          this.base64Data = this.retrieveResonse.image;
          this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
        }
      );
    }

    _base64ToArrayBuffer(base64: any): ArrayBuffer {
      var binary_string = window.atob(base64);
      var len = binary_string.length;
      var bytes = new Uint8Array(len);
      for (var i = 0; i < len; i++) {
          bytes[i] = binary_string.charCodeAt(i);
      }
      return bytes.buffer;
  }

}
