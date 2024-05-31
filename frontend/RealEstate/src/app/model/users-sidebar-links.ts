export class UsersSidebarLinks {

   public static options:Array<any>=[
    {
        UserBuyer:
        [
                 {label:"Profile Details",link:"/userBuyer/user-dashboard/user-profile"},
                { label:"Edit Profile",link:"/userBuyer/user-dashboard/user-editprofile"},
                {label:"Favorite Properties",link:"/userBuyer/user-dashboard/user-favorites"}             
        ],
        UserAgent:
        [
            {label:"Profile Details",link:"/userAgent/user-dashboard/profile"},
               { label:"Update Profile details",link:"/userAgent/user-dashboard/updateprofile"},
                {label:"Add Property",link:"/userAgent/user-dashboard/addproperties"} ,
                {label:"Enquiry box",link:"/userAgent/user-dashboard/enquiry"} ,
                {label:"Your Listed Properties",link:"/userAgent/user-dashboard/view-properties-listed"}                
        ],
        Admin:
        [
            {label:"View Users",link:""},
            {label:"View Agents",link:""},
            {label:"Send Users Message",link:""},
            {label:"Send Agents Message",link:""},
        ]

    }
   ]
}

