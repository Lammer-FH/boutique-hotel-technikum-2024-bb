<template>
  <nav class="navbar">
    <ul>
      <li v-for="(item, index) in navItems" :key="index">
        <router-link :to="item.link">{{ item.name }}</router-link>
      </li>
    </ul>
    <RouterLink to="/">Go to Home</RouterLink>
  </nav>
</template>

<script>
export default {
  name: 'NavigationBar',
  data() {
    return {
      navItems: [
        { name: 'Home', link: '/' },
        { name: 'About', link: '/about' },
        { name: 'Rooms', link: '/rooms' }
      ]
    };
  }
};
</script>

<style scoped>
.navbar {
  background-color: #333;
  overflow: hidden;
}

.navbar ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  display: flex;
}

.navbar li {
  padding: 14px 20px;
}

.navbar li a {
  color: white;
  text-align: center;
  text-decoration: none;
  display: block;
}

.navbar li a:hover {
  background-color: #ddd;
  color: black;
}
</style>
