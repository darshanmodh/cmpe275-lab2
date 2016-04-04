package edu.sjsu.cmpe275.lab2;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

	@RequestMapping(value = "/profile/{userid}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable("userid") String userid, Model model) {
		try {
			System.out.println("USER_ID=" + userid);
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("cmpe275-lab2");
			EntityManager entitymanager = emfactory.createEntityManager();
			entitymanager.getTransaction().begin();
			Query query = entitymanager.createQuery("delete from Profile p where p.userid=:userid");
			query.setParameter("userid", userid);
			int deleted = query.executeUpdate();
			entitymanager.getTransaction().commit();
			System.out.println("DELETED=" + deleted);
			return "profile";
		} catch (Exception e) {
			return "notfound";
		}
	}

	@RequestMapping(value = "/profile/{userid}", params = { "brief" }, method = RequestMethod.GET)
	public String userid(@PathVariable("userid") String userid, @RequestParam(value = "brief") String brief,
			Model model) {
		System.out.println("USER_ID=" + userid);
		System.out.println("Brief=" + brief);
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("cmpe275-lab2");
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createQuery("select p from Profile p where p.userid=:userid");
		query.setParameter("userid", userid);
		try {
			Profile profile = (Profile) query.getSingleResult();
			model.addAttribute("userid", profile.getUserid());
			model.addAttribute("firstname", profile.getFirstname());
			model.addAttribute("lastname", profile.getLastname());
			model.addAttribute("email", profile.getEmail());
			model.addAttribute("address", profile.getAddress());
			model.addAttribute("organization", profile.getOrganization());
			model.addAttribute("aboutmyself", profile.getAboutmyself());
			return "profile_brief";
		} catch (NoResultException e) {
			return "notfound";
		}
	}

	@RequestMapping(value = "/profile/{userid}", method = RequestMethod.GET)
	public String userid(@PathVariable("userid") String userid, Model model) {
		try {
			System.out.println("USER_ID=" + userid);
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("cmpe275-lab2");
			EntityManager entitymanager = emfactory.createEntityManager();
			Query query = entitymanager.createQuery("select p from Profile p where p.userid=:userid");
			query.setParameter("userid", userid);
			Profile profile = (Profile) query.getSingleResult();
			model.addAttribute("userid", profile.getUserid());
			model.addAttribute("firstname", profile.getFirstname());
			model.addAttribute("lastname", profile.getLastname());
			model.addAttribute("email", profile.getEmail());
			model.addAttribute("address", profile.getAddress());
			model.addAttribute("organization", profile.getOrganization());
			model.addAttribute("aboutmyself", profile.getAboutmyself());
			return "profile_get";
		} catch (NoResultException e) {
			return "notfound";
		}
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView createUser() {
		return new ModelAndView("profile", "command", new Profile());
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("profile") Profile profile) {
		System.out.println("IN CREATE");
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("cmpe275-lab2");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(profile);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		return "profile";
	}

	@RequestMapping(value = "/profile/{userid}", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("profile") Profile profile, @PathVariable("userid") String userid,
			Model model) {
		System.out.println("IN UPDATE");
		System.out.println("USER_ID=" + userid);
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("cmpe275-lab2");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("update Profile p SET " + "p.firstname='" + profile.getFirstname()
				+ "', p.lastname='" + profile.getLastname() + "', p.email='" + profile.getEmail() + "', p.address='"
				+ profile.getAddress() + "', p.organization='" + profile.getOrganization() + "', p.aboutmyself='"
				+ profile.getAboutmyself() + "' WHERE p.userid=:userid");
		query.setParameter("userid", userid);
		int updated = query.executeUpdate();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		System.out.println("UPDATED=" + updated);
		return "profile_get";
	}

}
