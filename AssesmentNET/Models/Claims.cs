namespace AssesmentNET.Models
{
    public class Claims
    {
        public int Id { get; set; } 
        public string Description { get; set; }
        public string Status { get; set; }  
        public string Date { get; set; }

        public Vehicles Vehicle_Id { get; set; }
    }
}
