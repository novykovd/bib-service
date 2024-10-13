Technologies used: Spring mvc/jpa/boot/security/thymeleaf, React, SQL, Docker, AWS, Github Actions

---
Idea: Website that allows you to track your favourite literature and in the future leave reviews. It was hosted on a public domain using Amazon's container services. 

---
Features:
- GUI built with React and threeJS to allow 3D rendering
- Containerization

---
Problems:
- The db output is not instant, hence the requests for information should be asynchronous
  - Hence instead of passing all information in a thymeleaf template instead the bulk of information is made with a asynchronous ajax request
  - This required the spring container to expose a rest api for the request to pull from
  - The requests had to be CORS authorized in order to allow for ajax
- React development environment and Spring are completely separate and it took a while to transfer updates
  - hence to optimize development process I built an automated pipeline to deliver updates instantly using github actions

