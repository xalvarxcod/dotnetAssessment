namespace final_asp_project.Models
{
    public class Claim
    {
        public int ClaimId { get; set; }
        public string Description { get; set; }
        public string Status { get; set; }
        public string Date { get; set; }  
        public int VehicleId { get; set; }
        public Vehicle Vehicle { get; set; }
    }
}
