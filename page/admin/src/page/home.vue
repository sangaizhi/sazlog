<template>
	<div id='home'>
		<topnav></topnav>
		<leftnav></leftnav>
		<div class="content-container">
			<router-view class="view"></router-view>
		</div>
	</div>
</template>
<script>
	import leftnav from './nav/leftnav.vue';
	import topnav from './nav/topnav.vue';
	export default {
		data() {
			return {}
		},
		components: {
			leftnav,
			topnav
		}
	}
</script>
<style>
	#home {
		width: 100%;
		height: 100%;
		overflow: hidden;
	}
	.content-container{
		overflow: hidden;
		margin: 50px 0 0 200px;
		width: calc(100% - 200px);
		height: calc(100% - 50px);
		position: absolute;
		left: 0;
		top: 0;
	}
</style>