<template v-if="awesome">
  <div class="hello">
    <h1>{{ msg }}</h1>
    <p>
      afsdfasfffffff
    </p>
    <h3>Function</h3>
    <ul>
      <li>data()</li>
      <li v-if="awesome">{{somevalue}}</li>
      <li v-else>{{othervalue}}</li>
    </ul>
    <ul>
      <li v-for="(item, index) in items" :key="item.id">
        {{ index }} - {{ item.message.toUpperCase() }}
      </li>
    </ul>
    <ul>
      <template v-for="item in items" :key="item.id">
        <li>{{ item.message }} </li>
        <li class="divider" role="presentation"> </li>
      </template>
    </ul>
    <input type="text" v-model="somevalue" >

    <h2>{{count}}</h2>
    <button v-on:click="countUp()">count up</button>
    <button @click="countUp()">count up</button>


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
      items: [{ message: 'Foo' }, { message: 'Bar' }],
      count: 0
    }
  },
  methods: {
    countUp() {
      this.count++;
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
