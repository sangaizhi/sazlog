<template>
	<div id="app">
		<router-view class='view'></router-view>
	</div>
</template>

<script>
	export default {
		name: 'app',
		data() {
			return {}
		}
	}
</script>

<style lang="scss">
	#app {
		font-family: 'Avenir', Helvetica, Arial, sans-serif;
		-webkit-font-smoothing: antialiased;
		-moz-osx-font-smoothing: grayscale;
		color: #CCC;
		width: 100%;
		height: 100%;
	}
</style>