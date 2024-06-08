<script>

export default {
  name: 'NavigationBarElement',
  props: ["elementName"],
  data() {
    return {
      name: this.elementName
    }
  },
}
</script>

<template>
  <div>
    <p>{{name}}</p>
  </div>
</template>