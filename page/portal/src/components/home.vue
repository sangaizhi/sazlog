<template>
	<div>
		<leftNav></leftNav>
		<topNav></topNav>
		<div class="content-container">
			<router-view class="view"></router-view>
		</div>
		
	</div>
</template>

<script>
	import leftNav from '../components/nav/leftNav.vue';
	import topNav from '../components/nav/topNav.vue';
	import container from '../components/container.vue';
	export default {
		data() {
			return {}
		},
		components: {leftNav,topNav,container}
	}
</script>

<style>
.content-container{
		position: absolute;
		width: 100%;
		height: 100%;
		left: 200px;
		top:50px;
		bottom: 0;
		right: 0;
		background-color: #f0f3f4;
	}
</style>