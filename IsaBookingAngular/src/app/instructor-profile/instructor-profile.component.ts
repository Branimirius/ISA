import { Component, Input, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { Fishing } from '../models/fishing';
import { FishingService } from '../services/fishing.service'
import { AuthenticationService } from '../services/authentication.service';
import { Observable } from 'rxjs';
import { FishingImage } from '../models/fishing-image';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { FishingReservation } from '../models/fishing-reservation';
import { User } from '../models/user';
import { UserService } from '../services/user.service';
import { MatDialog } from '@angular/material/dialog';
import { FishingReview } from '../models/fishing-review';
import { Availability } from '../models/availability';

@Component({
  selector: 'app-instructor-profile',
  templateUrl: './instructor-profile.component.html',
  styleUrls: ['./instructor-profile.component.css']
})
export class InstructorProfileComponent implements OnInit {
  instructor: User;
  peekProfile: User; 
  fishingProfile: Fishing;
  fishingProfiles: Fishing[];
  backupProfiles: Fishing[];
  fishingImages: FishingImage[];
  fishingReservations: FishingReservation[];
  allFishingReservations: FishingReservation[];
  availableReservations: FishingReservation[];
  clients: User[];
  allClients: User[];
  selectedFile: File;
  retrievedImages: any[];
  slideIndex: number;
  base64Data: any;
  retrieveResonse: any;
  message: string;
  imageName: any;
  query: string;
  currPass: string;
  newPass: string;
  confPass: string;
  review: FishingReview;
  dialogUser: number;
  newAvailability: Availability;

  public isCollapsed = false;
  public isCollapsed1 = false;
  @Input() public newReservation: FishingReservation;
  @Input() public newFishing: Fishing;
  @Input() public updateInstructor: User;
  @ViewChild('secondDialog', { static: true })
  secondDialog!: TemplateRef<any>;
  @ViewChild('firstDialog', { static: true })
  firstDialog!: TemplateRef<any>;

  constructor(private fishingService: FishingService,
              private authenticationService: AuthenticationService,
              private httpClient: HttpClient,
              private userService: UserService,
              private dialog: MatDialog
              ) {
    this.instructor = this.authenticationService.currentUserValue;
    this.updateInstructor = this.authenticationService.currentUserValue;
    this.fishingProfile = new Fishing;
    this.fishingProfiles = [];
    this.backupProfiles = [];
    this.fishingImages = [];
    this.fishingReservations = [];
    this.availableReservations = [];
    this.allFishingReservations = [];
    this.retrievedImages = [];
    this.clients = [];
    this.allClients = [];
    this.message = "";
    this.selectedFile = new File([""], "filename");
    this.slideIndex = 1;
    this.query = "";
    this.newReservation = new FishingReservation();
    this.newFishing = new Fishing();
    this.currPass = "";
    this.newPass = "";
    this.confPass = "";
    this.dialogUser = 0;
    this.review = new FishingReview();
    this.newAvailability = new Availability();
    this.peekProfile = new User();

    
    //this.GetFishingProfile();
    this.GetFishingProfiles();
    this.GetFishingProfileGallery();
    this.GetFishingProfileReservations();
    this.GetClients();
    this.getImages();
   }

  ngOnInit(): void {
    //this.GetFishingProfile();
    this.GetFishingProfiles();
    this.GetFishingProfileGallery();
    this.GetFishingProfileReservations();
    this.GetClients();
    this.getImages();

    console.log("ODRADIO", this.fishingProfile.adress)
  }

  //needs to be changed
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
  GetFishingProfiles(){
    
    this.fishingService.GetFishingProfiles()
      .subscribe((data: any) => {
        this.fishingProfiles.length = 0;
        this.backupProfiles.length = 0;
        for(const d of (data as any)){
          if(this.authenticationService.currentUserValue.id == d.userId){          
            this.fishingProfiles.push(d);
            this.backupProfiles.push(d); 
          }         
        }
    })
  }
  GetFishingProfileGallery(){
    this.fishingService.GetFishingImages()
    .subscribe((data: any) => {
      this.fishingImages.length = 0;
      for(const d of (data as any)){
        if(this.fishingProfile.id == d.fishingClass.id){
          if(!this.ImageAlreadyLoaded(d.id)){
            this.fishingImages.push(d);
          }
        }
      }
      console.log("Images: ", this.fishingImages)
    })
  }
  GetFishingProfileReservations(){
    this.fishingService.GetFishingReservations()
    .subscribe((data: any) => {
      this.fishingReservations.length = 0;
      this.availableReservations.length = 0;
      this.allFishingReservations.length = 0;
      for(const d of (data as any)){
        if(this.instructor.id == d.fishingClass.userId){
          this.allFishingReservations.push(d);
        }
        if(this.fishingProfile.id == d.fishingClass.id){
          if(d.userId != 0){
            console.log(d)
            this.fishingReservations.push(d);
          }
          else{
            console.log(d)

            this.availableReservations.push(d);
          }
        }
      }
    })
  }

  GetClients(){
    this.userService.GetAllUsers()
    .subscribe((data: any) => {
      this.clients.length = 0;
      this.allClients.length = 0;
      for(const d of (data as any)){
        if(d.regType == "CLIENT"){
          this.allClients.push(d);
        }
        for(let res of this.allFishingReservations){
          if(res.userId == d.id){
            this.clients.push(d);
          }
        }
      }
    })
  }

  GetFishingAdventure(id: number): Fishing{
    for(let f of this.fishingProfiles){
      if(f.id == id){
        return f;
      }
    }
    return new Fishing();
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
        this.getImages();
      }
      );
      this.getImages();
  }
    //Gets called when the user clicks on retieve image button to get the image from back end
    getImages() {
    //Make a call to Sprinf Boot to get the Image Bytes.
      this.httpClient.get('http://localhost:8081/api/fishingImages/get/' + this.fishingProfile.id)
        .subscribe(
          (res: any) => {
            this.retrievedImages.length = 0;
            this.retrieveResonse = res;
            if(res != null){
              for(const d of res as any){
                this.base64Data = d.image;
                this.retrievedImages.push('data:image/jpeg;base64,' + this.base64Data);
              }
              this.showSlides(this.slideIndex);
              this.currentSlide(this.slideIndex);
            }
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
  // Next/previous controls
plusSlides(n: number) {
  this.showSlides(this.slideIndex += n);
}

// Thumbnail image controls
currentSlide(n: number) {
  this.showSlides(this.slideIndex = n);
}

showSlides(n: number) {
  if(this.retrievedImages.length > 0){
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    if (!slides || !dots) {
      return; // don't do the rest
    }
    if (n > slides.length) {this.slideIndex = 1}
    if (n < 1) {this.slideIndex = slides.length}
    for (i = 0; i < slides.length; i++) {
        slides[i].setAttribute("style", "display: none");

    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[this.slideIndex-1].setAttribute("style", "display: block");
    dots[this.slideIndex-1].className += " active";
  }
}

formatDate(date: Date) : string{
  let retVal = ""
  retVal = date.toString().substring(0,10) + " " + date.toString().substring(11,16)
  return retVal
}

public addAvailableReservation(){
  this.newReservation.fishingClass = this.fishingProfile;
  this.newReservation.userId = 0;
  this.newReservation.duration = (new Date(this.newReservation.end).getTime() - new Date(this.newReservation.start).getTime()) / (1000 * 60);
  console.log(this.newReservation);
  this.fishingService.AddReservation(this.newReservation).subscribe((data:any) => {
    this.GetFishingProfileReservations();
  });
}

public addReservation(){
  this.newReservation.duration = (new Date(this.newReservation.end).getTime() - new Date(this.newReservation.start).getTime()) / (1000 * 60);
  console.log(this.newReservation);
  this.fishingService.AddReservation(this.newReservation).subscribe((data:any) => {
    this.GetFishingProfileReservations();
  });
}

public addNewFishing(){
  this.newFishing.userId = this.fishingProfiles[0].userId;
  this.fishingService.AddNewFishing(this.newFishing).subscribe((data:any) => {
    this.GetFishingProfiles();
  });
}

validate() : boolean{
  if (
    this.newReservation.start == null || this.newReservation.end == null ||
     this.newReservation.location == ""  || this.newReservation.maxCap == 0
  )
    return false;
  else 
    return true;
}

openFishing(fishing: Fishing){
  this.fishingProfile = fishing;
  this.GetFishingProfileReservations();
  this.getImages();
}

closeFishing(){
  this.fishingProfile = new Fishing();
  //this.GetFishingProfileReservations();
}

deleteFishing(fishing: number){
  
  this.fishingService.DeleteFishing(fishing).subscribe((data: any) => {
    if(data.deleted == true){
      this.fishingProfiles.filter(el => el.id != fishing);
      this.GetFishingProfiles();
    }
    else{
      alert("You can't delete reserved fishing adventure.");
    }
    
    
  }); 
}

searchFishing(){
  this.fishingProfiles = JSON.parse(JSON.stringify(this.backupProfiles));
  this.fishingProfiles = this.fishingProfiles.filter(el => (el.adress.toUpperCase().includes(this.query.toUpperCase()) || el.description.toUpperCase().includes(this.query.toUpperCase())));

}

updateInstructorProfile(){
  if(this.currPass == "" && this.newPass == "" && this.confPass == ""){
    this.userService.UpdateUser(this.updateInstructor).subscribe((data: any) => {
      this.instructor = this.updateInstructor;  
      alert("Successfuly updated.");  
    }); 
  }
  else{
    if(this.currPass == this.instructor.password && this.newPass == this.confPass){
      this.updateInstructor.password = this.newPass;
      this.userService.UpdateUser(this.updateInstructor).subscribe((data: any) => {
        this.instructor = this.updateInstructor;
        alert("Successfuly updated.");  
      });
    }
    else{
      alert("Your current password or confirm password is wrong. Try again or leave empty.")
    }
  }
}

isDoneAndNotEmpty(r: FishingReservation): boolean{
  if(((Date.now() - new Date(r.end).getTime()) > 0) && (r.userId != 0)){
    return true;
  }
  return false;
}

isDone(end: Date): boolean{
  if(((Date.now() - new Date(end).getTime()) > 0)){
    return true;
  }
  return false;
}

openDialogWithoutRef(userId: number, first: boolean) {
  this.peekProfile = this.getClient(userId);
  if(first){
    this.dialog.open(this.firstDialog);
    this.dialogUser = userId;
  }
  else{
    this.dialog.open(this.secondDialog);
    this.dialogUser = userId;
    console.log(userId);
  }
  
}

submitReview(){
  this.review.instructor = this.instructor;
  this.review.client = this.getClient(this.dialogUser);
  console.log(this.clients);
  console.log(this.review);
  this.fishingService.AddFishingReview(this.review).subscribe();
}
getClient(id: number): User{
  for(let c of this.clients){
    if(c.id == id){
      return c;
    }
  }
  return new User();
}
addAvailability(){
  console.log(this.newAvailability);
  if((new Date(this.newAvailability.to).getTime() - new Date(this.newAvailability.from).getTime())  > 0){
    this.newAvailability.instructor = this.instructor.id;
    this.userService.AddAvailability(this.newAvailability).subscribe();
  }
  else{
    alert("Dates are incorrectly chosen.");
  }
}

}
