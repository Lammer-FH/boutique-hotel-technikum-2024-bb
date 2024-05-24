<template v-if="awesome">
  <div class="hello">
    <h1>{{ msg }}</h1>
    <p>
      For a guide and recipes on how to configure / customize this project,<br>
      check out the
      <a href="https://cli.vuejs.org" target="_blank" rel="noopener">vue-cli documentation</a>.
    </p>
    <h3>Function</h3>
    <ul>
      <li>data()</li>
      <li v-if="awesome">{{somevalue}}</li>
      <li v-else>{{othervalue}}</li>
    </ul>
    <ul>
      <li v-for="(item, index) in items" :key="item.id">
        {{ index }} - {{ item.message }}
      </li>
    </ul>
    <ul>
      <template v-for="item in items" :key="item.id">
        <li>{{ item.message }} </li>
        <li class="divider" role="presentation"> </li>
      </template>
    </ul>
    <input type="text" v-model="somevalue" >


  </div>
</template>


<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data() {
    return {
      somevalue: "fooo",
      othervalue: "baaaa",
      awesome: true,
      items: [{ message: 'Foo' }, { message: 'Bar' }]
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
