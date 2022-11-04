using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using AssesmentNET.Models;

namespace AssesmentNET.Controllers
{
    public class OwnerController : Controller
    {
        private IList<Owners> ownersList = new List<Owners>
        {new Owners() { Id = 1, DriverLicense = "123", FirstName = "Pedro", LastName = "Perez"},
        new Owners() { Id = 1, DriverLicense = "1234", FirstName = "Alvaro", LastName = "Rert"},
        new Owners() { Id = 1, DriverLicense = "12345", FirstName = "Roberto", LastName = "Messi"},
        new Owners() { Id = 1, DriverLicense = "123456", FirstName = "Leo", LastName = "Ronaldo"}
        };
        // GET: OwnerController
        public ActionResult Index()
        {
            return View(ownersList.OrderBy(v => v.Id).ToList());
        }

        // GET: OwnerController/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: OwnerController/Create
        public ActionResult Create()
        {
            var ownerNew = new Owners();
            return View(ownerNew);
        }
        public ActionResult CreateVehicle(Owners owner)
        {
            ownersList.Add(owner);
            return RedirectToAction(nameof(Index));
        }

        

        // GET: OwnerController/Edit/5
        public ActionResult Edit(int id)
        {
            var own = ownersList.Where(o => o.Id == id).FirstOrDefault();
            return View(own);
        }

        // POST: OwnerController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: OwnerController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: OwnerController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
