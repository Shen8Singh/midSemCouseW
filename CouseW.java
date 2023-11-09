import java.util.*;
class CouseW{
    private static Scanner input= new Scanner(System.in);
    static String y="y";
    static String n="n";
    static int p = 0;
    static int q = 0;
    static int x = 0;
    static int g = 0;
    static int z = 0;
    static int ItemAdd=0; 
    static String name = "Shan";
    static String password="1234"; 
    static String Supplier[][]=new String[1][2];
    static String[] Categories =new String[1];
    static String[][] Items =new String[1][6];

    public static boolean checkSearchID(String ID,String[][]Supplier){

		boolean flog=false;

		for(int i=0;i<Supplier.length-1;i++){
			for(int j=0;j<Supplier[i].length;j++){

				if(Supplier[i][0] != null && Supplier[i][j].equals(ID)){
					flog = true;
					break;
				}
			}
		}
        return flog;
    }
    public static boolean checkUpdateID(String ID,String[][] arr){
		
		boolean rem= false;
 
        for(int i=0;i<arr.length;i++){
            x++;
            if(arr[i][0].equals(ID)){
                rem =true;        
                break;
            }    
        }
        return rem;
	}
    public static boolean ChecID(String ID,String[][]Supplier){

		boolean flog=true;

		for(int i=0;i<Supplier.length;i++){
			for(int j=0;j<Supplier[i].length;j++){

				if(Supplier[i][0] != null && Supplier[i][j].equals(ID)){
					flog = false;
					break;
				}
			}
		}
        return flog;
    }
    public static void ChangeTheCredentials(){
        clearConsole();
        System.out.println("\t\t\t+-----------------------------------------+");
        System.out.println("\t\t\t|          Change The Credentials         |");
        System.out.println("\t\t\t+-----------------------------------------+");

        boolean flog_1=true;
        boolean flog_2=true;
        do{
            System.out.print("Please enter the user name to verify it's you  :");
            String UserName=input.nextLine();

            if(UserName.equals(name)){

                do{
                    System.out.print("Enter Password : ");
                    String pass=input.nextLine();

                    if(pass.equals(password)){
						flog_1=false;
                        flog_2=false;
                        
                        System.out.print("Enter your new Password :");
                        String nawPass=input.nextLine();

                        password=nawPass;

                        System.out.print("Password changed successfully! Do you want to go hame page (y/n)?  ");
                        String rem=input.nextLine();

                        String A = "y";
                        String B = "n";

                        if(rem.equals(A)){
                            Main_Manu();
                        }
                        if(rem.equals(B)){
                        System.out.println("Bye");
                        }    
                    }
                    else{
                        System.out.println("Incorrect password try Agin! ");
                    }
                }while(flog_2);    
            }
            else{
                System.out.println("Invalid user name. Try Agin ! ");
            }
        }while(flog_1);
    }
    public static void SupplierManage() {
        clearConsole();
        System.out.println("\t\t\t+--------------------------------------+");
        System.out.println("\t\t\t|            Supplier Manage           |");
        System.out.println("\t\t\t+--------------------------------------+");

        System.out.println("[1] Add Supplier"+"\t\t\t[2] Update Supplier");
        System.out.println("[3] Delete Supplier"+"\t\t\t[4] View Suppliers");
        System.out.println("[5] Search Supplier"+"\t\t\t[6] Home Page");

        System.out.print("Enter an option to continue >");
        String rem= input.nextLine();

        boolean while_01 =false;

        do{
            switch (rem) {
                case "1" :
                    Add_Supplier();
                    break;

                case "2" :
                    Update_Suppler();
                    break;

                case "3" :
                    Delete_Supplier();
                    break;

                case "4" :
                    View_Suppliers();
                    break;

                case "5" :
                    Search_Suppliers();
                    break;

                case "6" :
                    Home_Page();
                    break;

                default:
                    System.out.println("wrong Commond. Plese Try Agin !");
                    while_01=true;
                    break;
            }
        }while(while_01);
    }
    public static void Add_Supplier(){
		clearConsole();

        System.out.println("\t\t\t+-------------------------------------+");
        System.out.println("\t\t\t|             ADD SUPPLIER            |");
        System.out.println("\t\t\t+-------------------------------------+");
         
        boolean while_01 = true;

        String SName="0";
        String S_id="0";

        Supplier =inceament_Supplier_array(Supplier);

        do {
            System.out.print("Supplier ID : ");
            S_id = input.nextLine();
            
            boolean flag = ChecID(S_id,Supplier);
            if(flag){
				for (int i = 0; i < Supplier.length-1; i++){
					for (int x = 0; x < Supplier[i].length; x++){

						if(Supplier[i][x]==null){

							if(x==0){
								Supplier[i][x]=S_id;
							}
							if(x==1){
								System.out.print("Enter name :");
								SName=input.nextLine();

								Supplier[i][x]=SName;
								while_01=false;	
							}
						}
					}	
				}	
			}else{
				System.out.println("it exist try again ");
			}
        } while (while_01);

        System.out.print("Are Enter New Supplear y/n :");
        String rem = input.nextLine ();

        if(rem.equals(y)){
			Add_Supplier();
		}
		if(rem.equals(n)){
			SupplierManage();
		}
    }
    public static String[][] inceament_Supplier_array(String[][] supplier) {
        String[][] temp = new String[supplier.length+1][2];
        for(int i = 0;i<supplier.length;i++){
            for(int x = 0;x<supplier[i].length;x++){
                temp[i][x] = supplier[i][x];
            }
        }
        return temp;        
    }
    public static void Update_Suppler(){
		clearConsole();

        System.out.println("\t\t\t+----------------------------------------+");
		System.out.println("\t\t\t|             Update Suplier             |");
        System.out.println("\t\t\t+----------------------------------------+");

        String sID = "0";
        String sName = "0";
        String NewsName = "0";

        boolean while_02 = true;
        do{
            System.out.print("Enter ID :");
            sID = input.nextLine();

            boolean rem = checkUpdateID(sID, Supplier);

            if(rem){
                System.out.print("Enter name : ");
                sName = input.nextLine();

                System.out.print("Enter new name :");
                NewsName = input.nextLine();

                Supplier[x-1][1]=NewsName;
                while_02=false;
            }else {
                System.out.println("Wrong ID Again ! ");
            }
        }while(while_02);

        boolean while_01=false;

        do{
            System.out.print("Updated Successfully! Do you want to update another supplier(y/n)? ");
            String num= input.nextLine();

            if(num.equals(y)){
                Update_Suppler();
            }
            if(num.equals(n)){
                SupplierManage();
            }else{
                System.out.println("Wrong Commond. Plese Try Agin !");
                while_01 = true;
            }
        }while(while_01);
    }
    public static String[][] DeletingSuppier(String[][] arr) {
        
        String[][] temp = new String[arr.length-1][2]; 

        for (int i = 0; i < arr.length-1; i++) {
            
            if (arr[i][0] != "Delete") {
                temp[q][0] = arr[i][0];
                temp[q][1] = arr[i][1];
                q++;
            }    
        }
        return temp;
    }
    public static boolean checkID(String ID, String[][] arr) {
        x=0;
        boolean flag = false;
        for (int i = 0; i < arr.length-1; i++) {
            x++;
            if (arr[i][0].equals(ID)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    public static void Delete_Supplier(){
		clearConsole();

        System.out.println("\t\t\t+-------------------------------------------+");
        System.out.println("\t\t\t|               DELETE SUPPLIER             |");
        System.out.println("\t\t\t+-------------------------------------------+");

        String sID = "0";
 
        boolean flag = true;
        do {
            System.out.print("Enter delete ID : ");
            sID = input.nextLine();

            boolean isIDValid = checkID(sID, Supplier);

            if (isIDValid) {
                Supplier[x - 1][0] = "Delete";
                Supplier[x - 1][1] = "Delete";

                Supplier = DeletingSuppier(Supplier);
                flag = false;
            } else {
                System.out.println("Wrong ID entered.");
            }
        } while (flag);

        boolean while_01 = false;

        do{
            System.out.print("Deleted successfully! Do you want to delete another(y/n)? ");
            String num = input.nextLine();

            if(num.equals(y)){
                Delete_Supplier();
            }
            if(num.equals(n)){
                SupplierManage();
            }else{
                System.out.println("Wrong Command. Plese Try Agin !");
                while_01 = true;
            }
        }while(while_01);
    }	
    public static void View_Suppliers(){
		clearConsole();

        System.out.println("\t\t\t+-----------------------------------------------+");
        System.out.println("\t\t\t|                 VIEW SUPPLIERS                |");
        System.out.println("\t\t\t+-----------------------------------------------+");

        System.out.println("+----------------------------+-----------------------------+");
		System.out.println("|         SUPPLIER ID        |       SUPPLIER NAME         |");
		System.out.println("+----------------------------+-----------------------------+");
		
		for (int i = 0; i < Supplier.length-1; i++)
		{
			for (int c = 0; c < Supplier[i].length; c++)
			{
				if (c==0)
				{
					System.out.print("|");
					for (int f = 0; f < 10; f++)
					{
						System.out.print(" ");
					}
					String id = Supplier[i][x];  
					System.out.print(id);
				
					int id_length = id.length();
				
					int row_value ,balance = 18;
				
					row_value = balance - id_length;
				
					for (int m = 0; m < row_value; m++)
					{
						System.out.print(" ");
					}
				
					System.out.print("|");
				}
				if (c==1){
					for (int a = 0; a < 10; a++){
				System.out.print(" ");
			}
			String name = Supplier[i][c];  
			System.out.print(name);
			
			int name_length = name.length();
			
			int row_value_right ,balance_right = 19;
			
			row_value_right = balance_right - name_length;
			
			for (int b = 0; b < row_value_right; b++)
			{
				System.out.print(" ");
			}
			
			System.out.println("|");
			
				}
			}
			
		}
			System.out.println("+----------------------------+-----------------------------+");
			
        boolean while_01 = true;
        do{
            System.out.print("Do you want to go supplier manage page(y/n)? ");
            String num = input.nextLine();
            if(num.equals(y)){
                while_01 = false;
                Search_Suppliers();
            }
            if(num.equals(n)){
                while_01 = false;
                Main_Manu();
            }else{
                System.out.println("Wrong Command. Plese Try Agin!");
            }
        }while(while_01);
    }
    public static void Search_Suppliers(){
		clearConsole();

        System.out.println("\t\t\t+---------------------------------------------------+");
        System.out.println("\t\t\t|                  SEARCH SUPPLIERS                 |");
        System.out.println("\t\t\t+---------------------------------------------------+");

        boolean while_01 = true;
        boolean while_02 = true;
        
        String num ="0";

        do{
            System.out.print("Supplier ID  :");
            String ID = input.nextLine();

            boolean flog_1 =checkSearchID(ID, Supplier);

            if(flog_1){
                while_01=false;
                
                System.out.print("Supplier Name :");
                String name= input.nextLine();
                System.out.println();

                System.out.print("added successfully! Do you want add another find (y/n)? ");
                num =input.nextLine();    
            }
        }while(while_01);

        do{
            if(num.equals(y)){
                while_02 = false;
                Search_Suppliers();
            }
            if(num.equals(n)){
                while_02 = false;
                SupplierManage();
            }else{
                System.out.println("Wrong Commond. Plese Try Agin !");
            }
        }while(while_02);
    }
    public static void Home_Page(){
		clearConsole();
        Main_Manu();
    }
    public static void StockManage() {
		clearConsole();
         
        System.out.println("\t\t\t+------------------------------------------------+");
        System.out.println("\t\t\t|                STOCK MANAGEMENT                |");
        System.out.println("\t\t\t+------------------------------------------------+");

        System.out.println("[1] Manage Item Categories"+"\t\t[2] Add Item");
        System.out.println("[3] Get Items Supplier wise "+"\t\t[4] View Items");
        System.out.println("[5] Rank Items Per Unit Price"+"\t\t[6] Home page");

        System.out.println();
        
boolean while_01 = true;

        do{
            System.out.print("Enter an option to continue >");
            String num= input.nextLine();

                switch (num) {
                    case "1":
                        while_01 = false;
                        ManageItemCategories();
                    break;

                    case "2":
                        while_01 = false;
                        AddItem();
                    break;

                    case "3":
                        while_01 = false;
                        GetItemsSupplierWise();
                    break;

                    case "4":
                        while_01 = false;
                        ViewItems();
                    break;

                    case "5":
                        while_01 = false;
                        RankItemsPerUnitPrice();
                    break;

                    case "6":
                        while_01 = false;
                       Main_Manu();
                    break;

                    default:
                        System.out.println("Wrong Commond. Plese Try Agin !");
                    break;
                }
        }while(while_01);
    }
    public static void LogOut() {    
    }
    public static void ExitTheSystem() {    
    }

    public static void RankItemsPerUnitPrice(){

        clearConsole();

        System.out.println("\t\t\t+----------------------------------------------+");
        System.out.println("\t\t\t|          RANK ITEMS PER UNIT PRICE           |");
        System.out.println("\t\t\t+----------------------------------------------+");

		 if (Items.length != 1){
				double[] item_price = new double[Items.length-1];
			for (int i = 0; i < Items.length-1; i++){
				item_price[i] = Double.parseDouble(Items[i][4]);
			}
			
			Arrays.sort(item_price);
			System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
			System.out.println("|      CODE       |       SID       |       CAT       |       DESC      |       PRICE     |        QTY      |");
			System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
			for (int i = 0; i < item_price.length; i++)
			{
				String item_price_s = Double.toString(item_price[i]);
				String[] index_number = SearchValueItemArray(Items,item_price_s);
				int index_num = Integer.parseInt(index_number[0]);
				System.out.print("|"); 
				for (int y = 0; y < 6; y++)
				{
					for (int a = 0; a < 5; a++) {
						System.out.print(" ");
					}
					System.out.print(Items[index_num][y]);
					
					int length = 12 - Items[index_num][y].length();
					
					for (int b = 0; b < length; b++){
						System.out.print(" ");
					}
					System.out.print("|");
				}
				System.out.println();
			}	System.out.println("+-----------------------------------------------------------------------------------------------------------+"+'\n');
			
        }
        boolean while_01 = true;

        do{
            System.out.print("Do you want to go Back(y/n)? ");
            String num = input.nextLine();
            if(num.equals(y)){
                while_01 = false;
                StockManage();
            }
            if(num.equals(n)){
                while_01 = false;
                Main_Manu();
            }else{
                System.out.println("Wrong Command. Plese Try Agin!");
            }
        }while(while_01);    
    }
    public static String[] SearchValueItemArray(String[][] item_array,String for_search){ // HELPING METHOD 02
		
		String[] to_delete = new String[1];
		
		 int up = 0;
		for (int i = 0; i < item_array.length; i++)
		{
			for (int x = 0; x < item_array[i].length; x++)
			{
				if (for_search.equals(item_array[i][x]))
				{
					to_delete[up] = String.valueOf(i);;
					// increment array 
					String[] temp  = new String[to_delete.length+1];
		
					for (int a = 0; a < to_delete.length; a++)
					{
						temp[a] = to_delete[a];
					}
					
					to_delete = new String[temp.length]; // add element to (to_delete)
					
					for (int d = 0; d < temp.length; d++)
					{
						to_delete[d] = temp[d];
					}
					up++;
					
					break;
				}else if ((i+1)== item_array.length && (x+1)==item_array[i].length && up==0)
				{
					System.out.println("search method  can not find ");
				}
			}
			
		}
			
		String[] temp_2 = new String[to_delete.length-1];
		for (int i = 0; i < to_delete.length-1; i++)
		{
			temp_2[i] = to_delete[i];
		}
		  
		return temp_2;
		
	}
    public static void ViewItems(){

        clearConsole();

        System.out.println("\t\t\t+-----------------------------------------------+");
        System.out.println("\t\t\t|                 VIEW ITEMS                    |");
        System.out.println("\t\t\t+-----------------------------------------------+");

		if (Items.length!=1){
            for (int i = 0; i < Categories.length-1; i++)
        {
            String[] print_array = SearchValueItemArray(Items,Categories[i]);
            
            
            System.out.println(Categories[i]+'\n');
            System.out.println("+-------------------+-------------------+-------------------+-------------------+-------------------+");
            System.out.println("|      CORDE        |      SID          |      DESE         |      PRICE        |      QTY          |");
            System.out.println("+-------------------+-------------------+-------------------+-------------------+-------------------+");
            
            for (int X = 0; X < print_array.length; X++)
            {
                
                    System.out.print("|");
                for (int Y = 0; Y < Items[X].length; Y++)
                {
                    if (Y!=2) 
                    {
                        for (int s = 0; s < 6; s++) 
                        {
                            System.out.print(" ");
                        }
                        
                        int integerValue = Integer.parseInt(print_array[X]);
                        System.out.print(Items[integerValue][Y]); 
                        
                        int string_length = 13 - Items[integerValue][Y].length();
                        for (int P = 0; P < string_length; P++) 
                        {
                            System.out.print(" ");
                        }
                        
                            System.out.print("|");
                        }
                }
                System.out.println();
            }
                    System.out.println("+-------------------+-------------------+-------------------+-------------------+-------------------+");
                    
                    for (int A = 0; A < 3; A++)
                    {
                        System.out.println();
                    }
        }
        }else
        {
            System.out.println("no item ");
        }
        boolean while_01 = true;

        do{
            System.out.print("Do you want to go Back(y/n)? ");
            String num = input.nextLine();
            if(num.equals(y)){
                while_01 = false;
                StockManage();
            }
            if(num.equals(n)){
                while_01 = false;
                Main_Manu();
            }else{
                System.out.println("Wrong Command. Plese Try Agin!");
            }
        }while(while_01);  

    }
    public static void GetItemsSupplierWise(){

        clearConsole();

        System.out.println("\t\t\t+---------- ------------------------------------+");
        System.out.println("\t\t\t|            GET ITEMS SUPPLIER WISE            |");
        System.out.println("\t\t\t+-----------------------------------------------+");

boolean while_02 = true;
		boolean while_01 = true;
		do
		{
		System.out.print("Supplier ID : ");
		String name_01 = input.next();
		System.out.print("Supplier name : ");
		String name_02 = input.next();
		boolean for_stop_else = true; 
		for (int i = 0; i < Supplier.length; i++)
		{
			if (name_01.equals(Supplier[i][0]) && name_02.equals(Supplier[i][1]))
			{	
				while_02 = true; 
				for_stop_else = false;
				for (int dou = 0; dou < 3; dou++) 
				{
					System.out.println();
				}
				
				String[] index_number_print = SearchValueItemArray(Items,Supplier[i][0]);
				System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
				System.out.println("|      CODE       |     CATEGORY    |   DESCRIPTION   |    UNIT PRICE   |        QTY      |");
				System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
				
					for (int x = 0; x < index_number_print.length; x++){
					
								System.out.print("|"); 
						
							int index = Integer.parseInt(index_number_print[x]);
						
							for (int y = 0; y < Items[index].length; y++){
								if (y!=1)
								{
									
									for (int a = 0; a < 5; a++)
									{
										System.out.print(" ");
									}
										System.out.print(Items[index][y]); 
										int length_01 = 12 - Items[index][y].length();
									for (int b = 0; b < length_01; b++)
									{
										System.out.print(" ");
									}
										System.out.print("|");	
								}
							}
							System.out.println();	
					}
					
					System.out.println("+-----------------------------------------------------------------------------------------+"+'\n');
				
			}else if (Supplier.length-1 == i && for_stop_else)
			{
				while_02 = false;
				System.out.println("it has not in the supplier array "+'\n');
			}
		
		}
        String y="y";
        String n="n";
        while (while_02){
				System.out.print("Do you want to search anothe supplier (y/n) ? ");
				y = input.next();
				if (y.equals("y"))
				{
					while_02 = false;
					System.out.println('\n'+""+'\n');
				}else if (n.equals("n"))
				{
					while_01 = false;
					while_02 = false;
					 
					StockManage();
					System.out.println("you selected no ");
				}else
				{
					System.out.println("it is wrong character try again !!!");
				}
			}
			
		} while (while_01);
    }
    public static void AddItem(){

        clearConsole();

        System.out.println("\t\t\t+------------------------------------------------+");
        System.out.println("\t\t\t|                    ADD ITEMS                   |");
        System.out.println("\t\t\t+------------------------------------------------+");

            boolean while_01=true;
      
            Items = IncrementItemArr(Items); 
    
            if(Supplier.length >=2){
                
                if(Categories.length >= 2){
                
                    do{
                    
                        System.out.print("Enter Item Code :");
                        String ItemCode= input.nextLine();
    
                        boolean flog= CheckItemID(Items,ItemCode);
                        if(flog){
    
                            for(int i=0;i<Items.length-1;i++){
    
                                if(Items[i][0]== null){
                                    Items[i][0]=ItemCode;
                                    while_01 = false;   
                                }
                            }
                        }else{
                            System.out.println("Allredy Item ID Try Again!");
                        }
                    }while(while_01);
                }else{
                    System.out.println("oops! It seems thst you don't have any suppliers in the system.\nDo you want to new Category?(y/n) ");
                    String num = input.nextLine();
                    if(num.equals(y)){
                        AddCategory();
                    }
                    if(num.equals(n)){
                        StockManage();                        
                    }
                }
            }else{
                System.out.println("oops! It seems thst you don't have any suppliers in the system.\nDo you want to new supplier?(y/n) ");
                String num = input.nextLine();
                if(num.equals(y)){
                    Add_Supplier();
                    
                }
                if(num.equals(n)){
                    StockManage();    
                }
            }
            System.out.println('\t'+"SUPPLIER TABLE ");
						
            System.out.println("+-------------+----------------------------+-----------------------------+");
            System.out.println("|     #       |         SUPPLIER ID        |       SUPPLIER NAME         |");
            System.out.println("+-------------+----------------------------+-----------------------------+");
            String number;
            
            for (int i = 0; i < Supplier.length-1; i++)
            {
                number = String.valueOf(i+1); 
                System.out.print("|");
                for (int x = 0; x < 4; x++)
                {
                    System.out.print(" ");
                }
                
                System.out.print(number);
                
                int first_place = 9;
                int number_length = number.length();
                int for_loop_01 = first_place - number_length;
                for (int y = 0; y < for_loop_01; y++)
                {
                    System.out.print(" ");
                }
                
                for (int x = 0; x < Supplier[i].length; x++)
                {
                    if (x==0)
                    {
                        System.out.print("|");
                        for (int f = 0; f < 10; f++)
                        {
                            System.out.print(" ");
                        }
                        String id = Supplier[i][x];  
                        System.out.print(id);
                    
                        int id_length = id.length();
                    
                        int row_value ,balance = 18;
                    
                        row_value = balance - id_length;
                    
                        for (int g = 0; g < row_value; g++)
                        {
                            System.out.print(" ");
                        }
                    
                        System.out.print("|");
                    }
                    if (x==1)
                    {
                        for (int a = 0; a < 10; a++)
                {
                    System.out.print(" ");
                }
                String name = Supplier[i][x];  
                System.out.print(name);
                
                int name_length = name.length();
                
                int row_value_right ,balance_right = 19;
                
                row_value_right = balance_right - name_length;
                
                for (int b = 0; b < row_value_right; b++)
                {
                    System.out.print(" ");
                }
                
                System.out.println("|");
                
                    }
                }
            }
            System.out.println("+-------------+----------------------------+-----------------------------+");


            System.out.print("Enter Supplier Number : ");
            String SupplierNum=input.nextLine();
    
            for(int j=0;j<Items.length-1;j++){
    
                if(Items[j][1]==null){
                    Items[j][1]=SupplierNum;
                }
            }
    
            System.out.println('\t'+"CATEGORY TABLE"+'\n');
						
			System.out.println("+-------------+----------------------------+");
			System.out.println("|     #       |         CATEGORY NAME      |");
			System.out.println("+-------------+----------------------------+");

			for (int x = 0; x < Categories.length-1; x++){
            
				System.out.print("|");
				for (int i = 0; i < 4; i++){
					System.out.print(" ");
				}					
				String number_category = String.valueOf(x+1);  
				System.out.print(number_category);

				int i_length = number_category.length();
				int for_loop_01 = 9 - i_length; 
										
				for (int i = 0; i <for_loop_01 ; i++){
				    System.out.print(" ");
				}
				System.out.print("|");
									
									
				for (int i = 0; i < 13; i++){
					System.out.print(" ");
				}
					String category_name = Categories[x]; 
					System.out.print(category_name);
				    int name_length  = category_name.length();
					int for_loop_02 = 15 - name_length; 
					for (int i = 0; i < for_loop_02; i++){
						System.out.print(" ");
					}
					System.out.println("|");
										
			}
			System.out.println("+-------------+----------------------------+"+'\n');
    
            System.out.print("Enter Supplier Number :");
            String CategoryNum=input.nextLine();
    
            for(int a=0;a<Items.length-1;a++){
    
                if(Items[a][2]==null){
                    Items[a][2]=CategoryNum;
                }
            }
    
            System.out.print("Enter Discrepshion :");
            String ItemDis=input.nextLine();
    
            for(int l=0;l<Items.length-1;l++){
    
                if(Items[l][3]==null){
                    Items[l][3]=ItemDis;
                }
            }
    
            System.out.print("Enter Price : ");
            String ItemPrice=input.nextLine();
    
    
            for(int k=0;k<Items.length-1;k++){
    
                if(Items[k][4]==null){
                    Items[k][4]=ItemPrice;
                }
            }
    
            System.out.print("Enter Qntity : ");
            String ItemQntity=input.nextLine();

    
            boolean check = true;
    
            do{
                System.out.print("Item Added. Do you want add another Itema(y/n)? ");
                String num=input.nextLine();
    
                String y = "y";
                String n = "n";
                if(num.equals(y)){
                    AddItem();
                    check = false;
                    check = false;
                }if(num.equals(n)){
                    StockManage();
                }else{
                    System.out.println("Wong Command plese Try Again!");
                }
    
            }while(check);
    }

    public static String[][] IncrementItemArr(String[][] Arr){

		
		String[][] temp = new String[Arr.length + 1][6];

		for(int i=0;i<temp.length-1;i++){
			for(int j = 0;j<temp[i].length;j++){
				temp[i][j]=Arr[i][j];
			}
		}
		return temp;
	}
    public static boolean CheckItemID(String[][] Arr,String itemID){

        boolean flog = true;
        
        for(int i= 0;i<Arr.length-1;i++){

            if(Arr[i][0] != null && Arr[i][0].equals(itemID)){

                flog=false;
                break;
            }
        }
        return flog;
    }
    public static void AddCategory(){
        clearConsole();

        Categories =CategoryArrIncrement(Categories);
        
        System.out.print("Enter the new item category");
        String cateName = input.next();
        
        for(int i = 0;i<Categories.length-1;i++){
            if(Categories[i]==null){
                Categories[i]= cateName;
            }                
        }
        System.out.println(Arrays.toString(Categories));

        System.out.print("Added successfully! Do you want to add another category(y/n)? ");
        String num = input.next();

        if(num.equals(y)){
            AddCategory();
        }
        if(num.equals(n)){
            Main_Manu();
        }
    }
    public static String[] CategoryArrIncrement(String[] arr){

        String[] temp = new String[arr.length+1];
        
        for(int i = 0;i<temp.length-1;i++){

            temp[i] = arr[i]; 
        }
        return temp;
    }
    public static void UpdateCategory(){
        clearConsole();
        boolean while_01 = true;

        do{
            System.out.println("Enter Catagory Name :");
            String name= input.next();

            boolean flog = CheckCatagory(Categories,name);

            if(flog){

                System.out.print("Enter new Catagory Name :");
                String NewCateName = input.next();

                Categories[g-2]=NewCateName;
                while_01 =false;
            }else{
                System.out.println("Wrong category Name");
            }
        }while(while_01);
        System.out.println(Arrays.toString(Categories));
    }
    public static boolean CheckCatagory(String[] catagory,String name){

        boolean flog = true;

        for(int i=0;i<catagory.length-1;i++){
            g++;

            if(catagory[i].equals(name)){
                flog = false;
                break;
            }
        } 
        return flog;
    }
    public static void DeleteCategory(){

        System.out.print("Enter delete Category name :");
        String DeleteName = input.nextLine();

        checkDeleteName(DeleteName,Categories);
    }
    public static void checkDeleteName(String name,String[] category){
        String[] temp = new String[category.length-1];

        for(int i = 0;i<Categories.length-1;i++){
            if(!category[i].equals(name)){
                temp[z]=category[i];
                z++;
            }
        }
       
    }
    public static void ManageItemCategories(){
        clearConsole();
        
        System.out.println("\t\t\t+------------------------------------------------+");
        System.out.println("\t\t\t|              MANEGE ITRM CATEGORIES            |");
        System.out.println("\t\t\t+------------------------------------------------+");

        System.out.println("[1] Add Category\t\t[2] Update Category");
        System.out.println("[3] Delete Category");
        System.out.println();

        System.out.print("Enter number :");
        int num = input.nextInt();

        if(num==1){
            AddCategory();
        }
        if(num==2){
            UpdateCategory();
        }
        if(num==3){
            DeleteCategory();
        }
    }
    public static void Main_Manu(){
        clearConsole();
        
        System.out.println("\t\t\t+----------------------------------------------------+");
        System.out.println("\t\t\t|                       Main_Manu                    |");
        System.out.println("\t\t\t+----------------------------------------------------+");

        System.out.println("[1] Change the Credentials "+"\t\t[2] Supplier Manage");
        System.out.println("[3] Stock Manage "+"\t\t\t[4] Log Out");
        System.out.println("[5] Exit the System ");
        System.out.println();

        boolean while_01 = true;

        do{
            System.out.print("Enter an option to continue > ");
            int option=new Scanner(System.in).nextInt();

            if(option==1){
                while_01 = false;
                ChangeTheCredentials();
            }
            if(option==2){
                while_01 = false;
                SupplierManage();
            }
            if(option==3){
                while_01 = false;
                StockManage();
            }
            if(option==4){
                while_01 = false;
                Loging_P();
            }
            if(option==5){
                
            }else{
                System.out.println("Wrong Command. Plese Try Agin !");
            }
        }while(while_01);    
    }
    public static void Loging_P(){
		 clearConsole();
        System.out.println("\t\t\t+--------------------------------------------+");
        System.out.println("\t\t\t|                 Loging Page                |");
        System.out.println("\t\t\t+--------------------------------------------+");

        boolean flog_1=true;
        boolean flog_2=true;
        do{
            System.out.print("Enter User Name : ");
            String UserName=input.nextLine();

            if(UserName.equals(name)){                
                do{
                    System.out.print("Enter User Password : ");
                    String pass=input.nextLine();

                    if(pass.equals(password)){
						flog_1=false;
                        flog_2=false;
                        Main_Manu();
                    }
                    else{
                        System.out.println("wrong password !\n try Agin !...");
                    }
                }while(flog_2);   
            }
            else{
                System.out.println("Wrong Name ! \n Try Agin !... ");
            }
        }while(flog_1);
    }
    public static void clearConsole() {   ///// clear consol
        try {
            // For Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            // For Unix/Linux/Mac
            else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception ex) {
            // Exception handling
            ex.printStackTrace();
        }
    }
    public static void main(String [] args){		
        Loging_P();
    }    
}







