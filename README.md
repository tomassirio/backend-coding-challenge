# Coding challenge for Backend Development

See details here: http://blog.papauschek.com/2019/10/analytics-coding-challenge/

## Steps followed

- Modified the GET method for products. Now it lists all the products with the currency associated to the country code
- Added a Currency ENUM which stores the currencies
- The POST method for purchases now receives a currency as a param as well.
    - This method now has a new feature running. It stores the recent purchases on a new List and refreshes it every 
    single time there is a new purchase. This mechanism was built around the complexity specification for Statistics.
- The statistics method now Retrieves the last purchases in O(1) since it doesn't have to filter the results on it's call
- The calculation on statistics was corrected and now it stores every transaction in EUR with it's corresponding calculation.
- The tests were modified to add a new currency and check if there was issues with the new currency field
- A Swagger interface was added. You can access it through [http://localhost:8080/swagger-ui.html#](http://localhost:8080/swagger-ui.html#)
- A logger was added on the two controllers. It doesn't do much, yet it was a feature added to show that logging is always 
a good practice

## :bust_in_silhouette: Who Am I?

<img src="https://media.discordapp.net/attachments/763140054825697301/763681938652528690/logo-design-branding-logo-tool-open-electronic-1-5f7ed02bc8247.png?width=468&height=468" width="410" height="410" /></p>

  <a href="mailto:tomassirio@gmail.com?Subject=Tomas%20You%20Are%20Amazing!">
      <img src="https://cdn2.downdetector.com/static/uploads/logo/image21.png" width="100"; height="100"/>
  </a>
  <a href="https://www.linkedin.com/in/tomassirio/">
      <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT6lpesO6pwpEcg_vPih50fcYPqy4F0Y_xw5Q&usqp=CAU" width="100"; height="100"/>
  </a>
  <a href="https://discord.io/siriobots">
      <img src="https://www.net-aware.org.uk/siteassets/images-and-icons/application-icons/app-icons-discord.png?w=585&scale=down" width="100"; height="100"/>
  </a>
  <a href="https://www.buymeacoffee.com/tomassirio1">
      <img src="https://i.pinimg.com/originals/60/fd/e8/60fde811b6be57094e0abc69d9c2622a.jpg" width="100"; height="100"/>
  </a>
